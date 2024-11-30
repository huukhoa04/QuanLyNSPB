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
import java.util.ArrayList;

@WebServlet("/NhanVienServlet/index")
public class _index extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            NhanVienBo nhanVienBo = new NhanVienBo();
            ArrayList<NhanVien> arrayList = nhanVienBo.getAllNhanVien();
            System.out.println("Size: " + arrayList.size());
            if(!arrayList.isEmpty()){;
                String destination = "/nhanvien/index.jsp";
                req.setAttribute("nhanvien", arrayList);
                RequestDispatcher dispatcher = req.getRequestDispatcher(destination);
                System.out.println(dispatcher.toString());
                dispatcher.forward(req, resp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
