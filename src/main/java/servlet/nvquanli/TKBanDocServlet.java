package servlet.nvquanli;

import dao.TKBanDocDAO;
import dao.TKTaiLieuDAO;
import model.TKBanDoc;
import model.TKTaiLieu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "TKBanDocServlet", value = "/tkBanDoc")
public class TKBanDocServlet extends HttpServlet {
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
            List<TKBanDoc> tkbandocs = new TKBanDocDAO().getTKBanDoc(ngaybatdau, ngayketthuc);
            errorDate = "";
            request.setAttribute("tkbandocs", tkbandocs);
        }

        request.setAttribute("errorDate", errorDate);
        String url = "/TKBanDoc.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
