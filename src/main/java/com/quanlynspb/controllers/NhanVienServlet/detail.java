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

@WebServlet("/NhanVienServlet/detail")
public class detail extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = (String) req.getAttribute("id");
//        try {
//            System.out.println("doGet nhanvien with id: " + id);
//            NhanVienBo nhv = new NhanVienBo();
//            NhanVien nhanVien = nhv.getNhanVienById(id);
//            System.out.println("NhanVien: " + nhanVien.getId());
//            if (Objects.equals(nhanVien.getId(), id)) {
//                req.setAttribute("nhanvien", nhanVien);
//                req.getRequestDispatcher("/nhanvien/detail.jsp").forward(req, resp);
//            }
//            else System.out.println("Cannot");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            System.out.println("doGet nhanvien with id: " + id);
            NhanVienBo nhv = new NhanVienBo();
            NhanVien nhanVien = nhv.getNhanVienById(id);
            System.out.println("NhanVien: " + nhanVien.getId());
            if (Objects.equals(nhanVien.getId(), id)) {
                req.setAttribute("nhanvien", nhanVien);
                req.getRequestDispatcher("/nhanvien/detail.jsp").forward(req, resp);
            }
            else System.out.println("Cannot");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
