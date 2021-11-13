package servlet.nvquanli;

import dao.LuotMuonDAO;
import dao.LuotNhapDAO;
import model.LuotNhap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LuotNhapTheoNccServlet", value = "/luotNhapTheoNcc")
public class LuotNhapTheoNccServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        int mancc = Integer.parseInt(request.getParameter("value"));
        LuotNhapDAO luotNhapDAO = new LuotNhapDAO();
        List<LuotNhap> luotnhaps = luotNhapDAO.getLuotNhapsTheoNcc(mancc);
        request.setAttribute("luotnhaps", luotnhaps);
        String url = "/XemLuotNhap.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
