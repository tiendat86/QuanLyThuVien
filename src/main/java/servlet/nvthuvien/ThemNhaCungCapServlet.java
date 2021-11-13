package servlet.nvthuvien;

import dao.NhaCungCapDAO;
import model.NhaCungCap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ThemNhaCungCapServlet", value = "/themNhaCungCap")
public class ThemNhaCungCapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
        NhaCungCap ncc = new NhaCungCap(nhaCungCapDAO.maxIDNhaCungCap()+1, request.getParameter("ten"),
                request.getParameter("diachi"), request.getParameter("sdt"));
        nhaCungCapDAO.themNhaCungCap(ncc);
        String url = "/TimNCC.jsp";
        request.setAttribute("addNccSuccess", "Bạn đã thêm nhà cung cấp thành công!");
//        out.println("<script type="text/javascript">");
//        out.println("alert('User or password incorrect');");
//        out.println("</script>");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
