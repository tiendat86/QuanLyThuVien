package servlet.nvquanli;

import dao.LuotMuonDAO;
import dao.PhieuMuonDAO;
import model.LuotMuon;
import model.PhieuMuon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhieuMuonTheoLuotMuonServlet", value = "/phieuMuonTheoLuotMuon")
public class PhieuMuonTheoLuotMuonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("idluotmuon"));
        LuotMuonDAO luotMuonDAO = new LuotMuonDAO();
        PhieuMuon phieumuon = new PhieuMuonDAO().getPhieuMuonTheoLuotMuon(id);
        request.setAttribute("nguoimuon", phieumuon.getListLuotMuon().get(0).getTheBanDoc().getBanDoc().getNguoiDung());
        request.setAttribute("phieumuon", phieumuon);
        String url = "/XemPhieuMuon.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
