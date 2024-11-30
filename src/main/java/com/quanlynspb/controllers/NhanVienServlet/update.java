package com.quanlynspb.controllers.NhanVienServlet;

import com.quanlynspb.models.bean.NhanVien;
import com.quanlynspb.models.bo.NhanVienBo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.Objects;

@WebServlet("/NhanVienServlet/update")
public class update extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            System.out.println("doGet nhanvien with id: " + id);
            NhanVienBo nhv = new NhanVienBo();
            NhanVien nhanVien = nhv.getNhanVienById(id);
            System.out.println("NhanVien: " + nhanVien.getId());
            if (Objects.equals(nhanVien.getId(), id)) {
                req.setAttribute("nhanVien", nhanVien);
                req.getRequestDispatcher("/nhanvien/update.jsp").forward(req, resp);
            }
            else System.out.println("Cannot");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String idpb = req.getParameter("idpb");
        String address = req.getParameter("address");
        try{
            NhanVienBo nhv = new NhanVienBo();
            NhanVien newNv = new NhanVien(id, name, idpb, address);
            int update = nhv.updateNhanVien(newNv);
            System.out.println("NhanVien affected: " + update);
            req.setAttribute("updateMessage", "Data updated on this Nhan Vien");
            req.setAttribute("nhanvien", newNv);
            req.getRequestDispatcher("/nhanvien/detail.jsp").forward(req, resp);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
