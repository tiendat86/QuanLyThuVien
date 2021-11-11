/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.nvthuvien;

import dao.LuotMuonDAO;
import dao.TheBanDocDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LuotMuon;
import model.TaiLieu;
import model.TheBanDoc;

/**
 *
 * @author dangt
 */
public class TimTheBanDocServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        
        String ma = request.getParameter("mathe");
        TheBanDocDAO tbddao = new TheBanDocDAO();
        TheBanDoc tbd = tbddao.getTheBanDocTheoMa(ma);
        String msg = "";
        if(tbd == null) {
            msg = "Không tìm thấy thẻ bạn đọc!";
        }
        List<TaiLieu> list = (List<TaiLieu>) session.getAttribute("tailieus");
        if(list != null) {
            list.removeAll(list);
            session.setAttribute("tailieus", list);
        }
        request.setAttribute("msg", msg);
        session.setAttribute("thebandoc", tbd);     
        String url = "/MuonTaiLieu.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        String ma = request.getParameter("mathe");
        TheBanDocDAO tbddao = new TheBanDocDAO();
        TheBanDoc tbd = tbddao.getTheBanDocTheoMa(ma);
        String msg = "";
        if(tbd == null) {
            msg = "Không tìm thấy thẻ bạn đọc!";
        } else {
            LuotMuonDAO luotMuonDAO = new LuotMuonDAO();
            List<LuotMuon> luotmuons = luotMuonDAO.getLuotMuonsChuaTraTheoMaTheBD(tbd.getMathe());
            session.setAttribute("luotmuons", luotmuons);
        }
        request.setAttribute("msg", msg);
        session.setAttribute("thebandoc", tbd);
        String url = "/TraTaiLieu.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
