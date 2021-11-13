package servlet.nvquanli;

import dao.TKTaiLieuDAO;
import model.TKTaiLieu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "TKTaiLieuServlet", value = "/tkTaiLieu")
public class TKTaiLieuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String errorDate;

        if(request.getParameter("ngaybatdau").equals("") || request.getParameter("ngayketthuc").equals("")) {
            errorDate = "Không được để trống!";
        } else {
        LocalDate ngaybatdau = LocalDate.parse(request.getParameter("ngaybatdau"), formatter);
        LocalDate ngayketthuc = LocalDate.parse(request.getParameter("ngayketthuc"), formatter);
        List<TKTaiLieu> tktailieus = new TKTaiLieuDAO().getTKTaiLieu(ngaybatdau, ngayketthuc);
            errorDate = "";
        request.setAttribute("tktailieus", tktailieus);
        }

        request.setAttribute("errorDate", errorDate);
        String url = "/TKTaiLieu.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
