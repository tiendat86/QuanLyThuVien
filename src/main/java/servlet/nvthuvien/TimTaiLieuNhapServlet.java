package servlet.nvthuvien;

import dao.TaiLieuDAO;
import model.TaiLieu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TimTaiLieuNhapServlet", value = "/timTaiLieuNhap")
public class TimTaiLieuNhapServlet extends HttpServlet {
    List<TaiLieu> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String url = "/NhapTaiLieu.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String url = "/NhapTaiLieu.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
