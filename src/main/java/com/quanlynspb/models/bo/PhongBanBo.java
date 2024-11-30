package com.quanlynspb.models.bo;

import com.quanlynspb.models.bean.NhanVien;
import com.quanlynspb.models.bean.PhongBan;
import com.quanlynspb.models.dao.PhongBanDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class PhongBanBo {
    PhongBanDao phongBanDao;
    public PhongBanBo() throws SQLException, ClassNotFoundException {
        phongBanDao = new PhongBanDao();
    }
    public ArrayList<PhongBan> getAllPhongBan() throws SQLException {
        return phongBanDao.getAllPhongBan();
    }
    public PhongBan getPhongBanById(String id) throws SQLException {
        return phongBanDao.getPhongBanById(id);
    }
    public PhongBan addPhongBan(PhongBan phongBan) throws SQLException {
        return phongBanDao.addPhongBan(phongBan);
    }
    public int updatePhongBan(PhongBan phongBan) throws SQLException {
        return phongBanDao.updatePhongBan(phongBan);
    }
    public int deletePhongBan(String id) throws SQLException {
        return phongBanDao.deletePhongBan(id);
    }
}
