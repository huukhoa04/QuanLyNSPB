package com.quanlynspb.controllers.NhanVienServlet;

import com.quanlynspb.models.bean.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/NhanVienServlet/detail")
public class detail extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            NhanVien nhanVien = (NhanVien) req.getAttribute("nhanvien");
            if (nhanVien != null) {
                req.setAttribute("nhanvien", nhanVien);
                req.getServletContext().getRequestDispatcher("/nhanvien/detail.jsp").forward(req, resp);
            }
            else System.out.println("Cannot");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
