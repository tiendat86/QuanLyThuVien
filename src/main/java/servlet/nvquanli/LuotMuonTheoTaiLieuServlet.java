package servlet.nvquanli;

import dao.LuotMuonDAO;
import model.LuotMuon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LuotMuonTheoTaiLieuServlet", value = "/luotMuonTheoTaiLieu")
public class LuotMuonTheoTaiLieuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        String matl = request.getParameter("value");
        LuotMuonDAO luotMuonDAO = new LuotMuonDAO();
        List<LuotMuon> luotmuons = luotMuonDAO.getLuotMuonTheoMaTL(matl);
        request.setAttribute("luotmuons", luotmuons);
        String url = "/XemLuotMuon.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
