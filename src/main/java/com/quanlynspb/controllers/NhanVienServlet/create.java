package com.quanlynspb.controllers.NhanVienServlet;

import com.quanlynspb.models.bean.NhanVien;
import com.quanlynspb.models.bo.NhanVienBo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;

@WebServlet("/NhanVienServlet/create")
public class create extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/nhanvien/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String destination = null;
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String idpb = req.getParameter("idpb");
        String address = req.getParameter("address");
        NhanVien nhanVien = new NhanVien(id, name, idpb, address);
        System.out.println(nhanVien);
        try {
            System.out.println("doPost nhanvien/create");
            System.out.println(req.getContextPath());
            System.out.println(req.getServletPath());
            NhanVienBo nhanVienBo = new NhanVienBo();
            NhanVien a = nhanVienBo.addNhanVien(nhanVien);
            if(a.getId().equals(nhanVien.getId())){
                req.setAttribute("nhanvien", a);
                req.getRequestDispatcher("/nhanvien/detail.jsp").forward(req, resp);
            }
            else System.out.println("Cannot");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
