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
import java.util.ArrayList;

@WebServlet("/PhongBanServlet/delete")
public class delete extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PhongBanBo phongBanBo = new PhongBanBo();
            ArrayList<PhongBan> arrayList = phongBanBo.getAllPhongBan();
            if(!arrayList.isEmpty()){
                req.setAttribute("phongban", arrayList);
                req.getRequestDispatcher("/phongban/delete.jsp").forward(req, resp);
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
                PhongBanBo phongBanBo = new PhongBanBo();
                for (int i = 0; i < selectedIds.length - 1; i++) {
                    System.out.println(selectedIds[i]);
                    phongBanBo.deletePhongBan(selectedIds[i]);
                }
                resp.sendRedirect(req.getContextPath() + "/PhongBanServlet/index");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
