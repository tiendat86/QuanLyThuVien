/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.BanDocDAO;
import dao.NVQuanLiDAO;
import dao.NVThuVienDAO;
import dao.NguoiDungDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BanDoc;
import model.NVQuanLi;
import model.NVThuVien;
import model.NguoiDung;

/**
 *
 * @author Tien Dat
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tentaikhoan = request.getParameter("tentaikhoan");        
        String matkhau = request.getParameter("matkhau");
        NguoiDung nguoidung = (NguoiDung) request.getAttribute("nguoidung");
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        BanDocDAO banDocDAO = new BanDocDAO();
        NVThuVienDAO nvtvdao = new NVThuVienDAO();
        NVQuanLiDAO nvqldao = new NVQuanLiDAO();
        nguoidung = nguoiDungDAO.dangnhap(tentaikhoan, matkhau);
        String url = "";
        String msg = "";
        if(nguoidung == null) {
            msg = "Nhập sai tên tài khoản hoặc mật khẩu";
            url = "/index.jsp";
        }
        else {
            BanDoc bd = banDocDAO.getBanDocTheoNguoiDung(nguoidung);
            NVThuVien nv = nvtvdao.getNVThuVienTheoNguoiDung(nguoidung);
            NVQuanLi ql = nvqldao.getNVQuanLiTheoNguoiDung(nguoidung);
            HttpSession session = request.getSession();
            if(bd != null) {
                session.setAttribute("bandoc", bd);
                url = "/BanDoc.jsp";
             } else if(nv!=null) {
                session.setAttribute("nhanvien", nv);
                url = "/NVThuVien.jsp";
            } else if(ql!=null) {
                session.setAttribute("quanli", ql);
                url = "/NVQuanLi.jsp";
            } else {
                  msg = "Nhập sai tên tài khoản hoặc mật khẩu";
                  url = "/index.jsp";
            }
        }
        request.setAttribute("nullLogin", msg);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
