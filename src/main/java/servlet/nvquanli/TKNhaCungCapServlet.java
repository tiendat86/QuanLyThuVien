package servlet.nvquanli;

import dao.TKNhaCungCapDAO;
import model.TKNhaCungCap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "TKNhaCungCapServlet", value = "/tkNhaCungCap")
public class TKNhaCungCapServlet extends HttpServlet {
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
        List<TKNhaCungCap> tknhacungcaps = new TKNhaCungCapDAO().getTKNhaCungCap(ngaybatdau, ngayketthuc);
            errorDate = "";
        request.setAttribute("tknhacungcaps", tknhacungcaps);
        }

        request.setAttribute("errorDate", errorDate);
        String url = "/TKNhaCungCap.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
