package servlet.nvthuvien;

import dao.NhaCungCapDAO;
import model.NhaCungCap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TimNhaCungCapServlet", value = "/timNhaCungCap")
public class TimNhaCungCapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        NhaCungCap ncc = new NhaCungCapDAO().getNhaCungCapTheoMa(Integer.parseInt(request.getParameter("value")));
        session.setAttribute("nhacungcap", ncc);
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

        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
        String ten = request.getParameter("ten");
        List<NhaCungCap> nccs = nhaCungCapDAO.getNhaCungCapTheoTen(ten);
        String nullNcc = "";
        if(nccs.size() == 0) {
            nullNcc = "Không tìm thấy nhà cung cấp!";
        }
        request.setAttribute("nullNcc", nullNcc);
        request.setAttribute("nccs", nccs);
        String url = "/TimNCC.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
