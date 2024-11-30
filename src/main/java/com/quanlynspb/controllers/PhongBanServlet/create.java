package com.quanlynspb.controllers.PhongBanServlet;

import com.quanlynspb.models.bean.NhanVien;
import com.quanlynspb.models.bean.PhongBan;
import com.quanlynspb.models.bo.NhanVienBo;
import com.quanlynspb.models.bo.PhongBanBo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;

@WebServlet("/PhongBanServlet/create")
public class create extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/phongban/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String destination = null;
        String idpb = req.getParameter("idpb");
        String tenpb = req.getParameter("tenpb");
        String desc = req.getParameter("desc");
        PhongBan phongBan = new PhongBan(idpb, tenpb, desc);
        System.out.println(phongBan.getIdPb());
        try {
            System.out.println("doPost phongban/create");
            System.out.println(req.getContextPath());
            System.out.println(req.getServletPath());
            PhongBanBo phongBanBo = new PhongBanBo();
            PhongBan a = phongBanBo.addPhongBan(phongBan);
            if(a.getIdPb().equals(phongBan.getIdPb())){
                req.setAttribute("phongban", a);
                req.getRequestDispatcher("/phongban/detail.jsp").forward(req, resp);
            }
            else System.out.println("Cannot");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
