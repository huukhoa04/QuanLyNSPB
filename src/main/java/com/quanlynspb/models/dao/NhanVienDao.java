package com.quanlynspb.models.dao;

import com.quanlynspb.models.bean.NhanVien;
import com.quanlynspb.models.data.QuanLyNspbDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class NhanVienDao {
    QuanLyNspbDb quanLyNspbDb;
    public NhanVienDao() throws SQLException, ClassNotFoundException {
        quanLyNspbDb = new QuanLyNspbDb();
    }
    public ArrayList<NhanVien> getAllNhanVien() throws SQLException {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "select * from `nhanvien`";
        ResultSet rs = quanLyNspbDb.executeQuery(sql);
        while (rs.next()) {
            list.add(
                    new NhanVien(
                            rs.getString("id"),
                            rs.getString("hoten"),
                            rs.getString("idpb"),
                            rs.getString("diachi")
                    )
            );
        }
        return list;
    }
    public NhanVien getNhanVienById(String id) throws SQLException {
        String sql = "select * from `nhanvien` where id = ?";
        ResultSet rs = quanLyNspbDb.executeQuery(sql.replace("?", id));
        if (rs.next()) {
            return new NhanVien(
                    rs.getString("id"),
                    rs.getString("hoten"),
                    rs.getString("idpb"),
                    rs.getString("diachi")
                    );
        }
        else return null;
    }
    public NhanVien addNhanVien(NhanVien nhanVien) throws SQLException {
        String id = nhanVien.getId();
        String name = nhanVien.getName();
        String idpb = nhanVien.getIdPb();
        String address = nhanVien.getAddress();
        String sql = MessageFormat.format("INSERT INTO `nhanvien`(`id`, `hoten`, `idpb`, `diachi`) VALUES (''{0}'',''{1}'',''{2}'',''{3}'')",id, name, idpb, address );
        boolean add = quanLyNspbDb.execute(sql);
        if (add) {
            return nhanVien;
        }
        else return null;
    }
    public int updateNhanVien(NhanVien nhanVien) throws SQLException {
        String id = nhanVien.getId();
        String name = nhanVien.getName();
        String idpb = nhanVien.getIdPb();
        String address = nhanVien.getAddress();
        String sql = MessageFormat.format("UPDATE `nhanvien` SET `hoten`=''{0}'',`idpb`=''{1}'',`diachi`=''{2}'' WHERE `id`=''{3}''",name, idpb, address, id );
        return quanLyNspbDb.executeUpdate(sql);
    }
    public int deleteNhanVien(String id) throws SQLException {
        String sql = MessageFormat.format("delete from `nhanvien` where `id` = ''{0}''", id);
        return quanLyNspbDb.executeUpdate(sql);
    }
}
