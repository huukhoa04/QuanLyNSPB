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
import java.util.Objects;

@WebServlet("/PhongBanServlet/detail")
public class detail extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idpb = req.getParameter("idpb");
        try {
            System.out.println("doGet phongban with idpb: " + idpb);
            PhongBanBo pbn = new PhongBanBo();
            PhongBan phongBan = pbn.getPhongBanById(idpb);
            System.out.println("PhongBan: " + phongBan.getIdPb());
            if (Objects.equals(phongBan.getIdPb(), idpb)) {
                req.setAttribute("phongban", phongBan);
                req.getRequestDispatcher("/phongban/detail.jsp").forward(req, resp);
            }
            else System.out.println("Cannot");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
