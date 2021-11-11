/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.bandoc;

import dao.TheBanDocDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BanDoc;
import model.TheBanDoc;

/**
 *
 * @author dangt
 */
public class LuuTheBanDocServlet extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        BanDoc bd = (BanDoc) session.getAttribute("bandoc");
        
        TheBanDocDAO tbddao = new TheBanDocDAO();
        String msg;
        
        if(tbddao.getTheBanDocTheoBanDoc(bd)!=null) {
            msg = "Bạn đã có thẻ bạn đọc!";
        } else {
            msg = "";
            String mathe = request.getParameter("mathe");
            String loaithe = request.getParameter("loaithe");
            TheBanDoc tbd = new TheBanDoc(mathe, loaithe, bd);
            tbddao.luuTheBanDoc(tbd);
        }
       String url = "/DKTheBanDoc.jsp";
       request.setAttribute("msg", msg);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
    }

}
