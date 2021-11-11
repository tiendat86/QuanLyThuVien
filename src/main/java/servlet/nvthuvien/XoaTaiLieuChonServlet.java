package servlet.nvthuvien;

import dao.TaiLieuDAO;
import model.TaiLieu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "XoaTaiLieuChonServlet", value = "/XoaTaiLieuChonServlet")
public class XoaTaiLieuChonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        String ma = request.getParameter("value");
        TaiLieu tailieu = new TaiLieuDAO().getTaiLieuTheoMa(ma);
        List<TaiLieu> tailieus = (List<TaiLieu>) session.getAttribute("tailieus");
        for(int i = 0; i < tailieus.size(); i++) {
            if(tailieus.get(i).getMatl().equals(tailieu.getMatl())) {
                tailieus.remove(i);
                break;
            }
        }
        session.setAttribute("tailieus", tailieus);
        String url = "/MuonTaiLieu.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
