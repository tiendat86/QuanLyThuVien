/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.nvthuvien;

import dao.TaiLieuDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TaiLieu;

/**
 *
 * @author dangt
 */
public class ChonTaiLieuMuonServlet extends HttpServlet {
    List<TaiLieu> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        TaiLieu tailieu = (TaiLieu) session.getAttribute("tailieu");
        String msg = "";
        if(list.size() > 0) {
                for(TaiLieu tl : list) {
                if(tl.getMatl().equals(tailieu.getMatl())) {
                    msg = "Tài liệu này đã được thêm";
                    break;
                }
            }
        }
        
        if(msg.equals("")) {
            list.add(tailieu);
        }
        request.setAttribute("msg3", msg);
        session.setAttribute("tailieus", list);
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
         TaiLieuDAO taiLieuDAO = new TaiLieuDAO();
        String ma = request.getParameter("matailieu");
        TaiLieu tailieu = taiLieuDAO.getTaiLieuTheoMa(ma);
        String msg2 = "";
        if (tailieu == null) {
            msg2 = "Không tìm thấy tài liệu";
        }
        request.setAttribute("msg2", msg2);
        session.setAttribute("tailieu", tailieu);
        String url = "/MuonTaiLieu.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
