package servlet.nvquanli;

import dao.LuotMuonDAO;
import model.LuotMuon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LuotMuonTheoBanDocServlet", value = "/luotMuonTheoBanDoc")
public class LuotMuonTheoBanDocServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        String matbd = request.getParameter("value");
        LuotMuonDAO luotMuonDAO = new LuotMuonDAO();
        List<LuotMuon> luotmuons = luotMuonDAO.getLuotMuonsTheoBanDoc(matbd);
        request.setAttribute("luotmuons", luotmuons);
        String url = "/XemLuotMuon.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
