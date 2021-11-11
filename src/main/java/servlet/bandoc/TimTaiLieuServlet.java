/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.bandoc;

import com.mysql.cj.util.StringUtils;
import dao.TaiLieuDAO;

import java.io.IOException;
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
 * @author Tien Dat
 */

public class TimTaiLieuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        TaiLieuDAO taiLieuDAO = new TaiLieuDAO();
        String ten = request.getParameter("tentailieu");
        List<TaiLieu> list = taiLieuDAO.getTaiLieuTheoTen(ten);
        request.setAttribute("listTaiLieu", list);
        String msg;
        if(list.size() == 0 && !StringUtils.isEmptyOrWhitespaceOnly(ten)) {
            msg = "Không tìm thấy tài liệu";
        }   else {
            msg = "";
        }
        request.setAttribute("nullTaiLieu", msg);
        String url = "/TimTaiLieu.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");        
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//         
//        TaiLieuDAO taiLieuDAO = new TaiLieuDAO();
//        String ten = request.getParameter("tentailieu");
//        List<TaiLieu> list = taiLieuDAO.getTaiLieuTheoTen(ten);
//        request.setAttribute("listTaiLieu", list);
//        String msg = "";
//        if(list.size() == 0) {
//            msg = "Không tìm thấy tài liệu";
//            request.setAttribute("msg", msg);
//        }   
//        String url = "/TimTaiLieu.jsp";
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
//        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
