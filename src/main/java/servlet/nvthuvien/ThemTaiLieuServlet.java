package servlet.nvthuvien;

import dao.NhaCungCapDAO;
import dao.TaiLieuDAO;
import model.NhaCungCap;
import model.TaiLieu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ThemTaiLieuServlet", value = "/themTaiLieu")
public class ThemTaiLieuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        String url;

        TaiLieuDAO taiLieuDAO = new TaiLieuDAO();
        if (request.getParameter("matailieu").equals("")) {
            request.setAttribute("addTLFailer", "Mã tài liệu không được để trống!");
            url = "/ThemTaiLieu.jsp";
        } else if(taiLieuDAO.getTaiLieuTheoMa(request.getParameter("matailieu")) == null ) {
            TaiLieu taiLieu = new TaiLieu(request.getParameter("matailieu"), request.getParameter("ten"),
                    Float.parseFloat(request.getParameter("gia")), request.getParameter("tacgia"), request.getParameter("nxb"),
                    Integer.parseInt(request.getParameter("soluong")));
            taiLieuDAO.themTaiLieu(taiLieu);
            request.setAttribute("addTLSuccess", "Bạn đã thêm tài liệu thành công!");
            url = "/NhapTaiLieu.jsp";
        } else {
            request.setAttribute("addTLFailer", "Mã tài liệu này đã có trong hệ thống!");
            url = "/ThemTaiLieu.jsp";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
