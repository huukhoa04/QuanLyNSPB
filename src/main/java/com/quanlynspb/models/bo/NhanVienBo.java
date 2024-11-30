package com.quanlynspb.models.bo;

import com.quanlynspb.models.bean.NhanVien;
import com.quanlynspb.models.dao.NhanVienDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class NhanVienBo {
    NhanVienDao nhanVienDao;
    public NhanVienBo() throws SQLException, ClassNotFoundException {
        nhanVienDao = new NhanVienDao();
    }
    public ArrayList<NhanVien> getAllNhanVien() throws SQLException {
        return nhanVienDao.getAllNhanVien();
    }
    public NhanVien getNhanVienById(String id) throws SQLException {
        return nhanVienDao.getNhanVienById(id);
    }
    public NhanVien addNhanVien(NhanVien nhanVien) throws SQLException {
        return nhanVienDao.addNhanVien(nhanVien);
    }
    public int updateNhanVien(NhanVien nhanVien) throws SQLException {
        return nhanVienDao.updateNhanVien(nhanVien);
    }
    public int deleteNhanVien(String id) throws SQLException {
        return nhanVienDao.deleteNhanVien(id);
    }
}
