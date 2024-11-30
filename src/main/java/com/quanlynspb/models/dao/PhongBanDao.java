package com.quanlynspb.models.dao;

import com.quanlynspb.models.bean.NhanVien;
import com.quanlynspb.models.bean.PhongBan;
import com.quanlynspb.models.data.QuanLyNspbDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class PhongBanDao {
    QuanLyNspbDb quanLyNspbDb;
    public PhongBanDao() throws SQLException, ClassNotFoundException {
        quanLyNspbDb = new QuanLyNspbDb();
    }
    public ArrayList<PhongBan> getAllPhongBan() throws SQLException {
        ArrayList<PhongBan> phongBanList = new ArrayList<>();
        String sql = "select * from `phongban`";
        try {
            ResultSet rs = quanLyNspbDb.executeQuery(sql);
            while (rs.next()) {
                phongBanList.add(new PhongBan(
                        rs.getString("idpb"),
                        rs.getString("tenpb"),
                        rs.getString("mota")
                ));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return phongBanList;
    }
    public PhongBan getPhongBanById(String id) throws SQLException {
        String sql = MessageFormat.format("select * from `phongban` where `idpb` = ''{0}''", id);
            ResultSet rs = quanLyNspbDb.executeQuery(sql);
            if (rs.next()) {
                return new PhongBan(
                        rs.getString("idpb"),
                        rs.getString("tenpb"),
                        rs.getString("mota")
                );
            }

        return null; //if notfound
    }
    public PhongBan addPhongBan(PhongBan phongBan) throws SQLException {
        String sql = MessageFormat.format("INSERT INTO `phongban`(`idpb`, `tenpb`, `mota`) VALUES (''{0}'',''{1}'',''{2}'')", phongBan.getIdPb(), phongBan.getTenPb(), phongBan.getDesc());
        boolean result = quanLyNspbDb.execute(sql);
        return phongBan;
    }
    public int updatePhongBan(PhongBan phongBan) throws SQLException {
        String sql = MessageFormat.format("UPDATE `phongban` SET `tenpb`=''{0}'',`mota`=''{1}'' WHERE `idpb` = ''{2}''", phongBan.getTenPb(), phongBan.getDesc(), phongBan.getIdPb());
        return quanLyNspbDb.executeUpdate(sql);
    }
    public int deletePhongBan(String id) throws SQLException {
        String sql = MessageFormat.format("DELETE FROM `phongban` WHERE `idpb` = ''{0}''", id);
        return quanLyNspbDb.executeUpdate(sql);
    }
}
