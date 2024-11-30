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
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/NhanVienServlet/delete")
public class delete extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            NhanVienBo nhanVienBo = new NhanVienBo();
            ArrayList<NhanVien> arrayList = nhanVienBo.getAllNhanVien();
            System.out.println("Size: " + arrayList.size());
            if(!arrayList.isEmpty()){;
                String destination = "/nhanvien/delete.jsp";
                req.setAttribute("nhanvien", arrayList);
                req.getRequestDispatcher(destination).forward(req, resp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Full request parameters: ");
        req.getParameterMap().forEach((key, value) -> System.out.println(key + ": " + String.join(",", value)));
        String[] selectedIds = req.getParameterValues("selectedIds");
        if(selectedIds != null){
            try {
                NhanVienBo nhanVienBo = new NhanVienBo();
                for (int i = 0; i < selectedIds.length - 1; i++) {
                    System.out.println(selectedIds[i]);
                    nhanVienBo.deleteNhanVien(selectedIds[i]);
                }
                resp.sendRedirect(req.getContextPath() + "/NhanVienServlet/index");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
