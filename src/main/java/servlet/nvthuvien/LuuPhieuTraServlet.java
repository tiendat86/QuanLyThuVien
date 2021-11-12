package servlet.nvthuvien;

import dao.LuotTraDAO;
import dao.PhieuTraDAO;
import dao.TaiLieuDAO;
import model.LuotTra;
import model.PhieuTra;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LuuPhieuTraServlet", value = "/LuuPhieuTraServlet")
public class LuuPhieuTraServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        PhieuTra phieuTra = (PhieuTra) session.getAttribute("phieutra");
        List<LuotTra> luottras = (List<LuotTra>) session.getAttribute("luottras");
        PhieuTraDAO phieuTraDAO = new PhieuTraDAO();
        LuotTraDAO luotTraDAO = new LuotTraDAO();
        TaiLieuDAO taiLieuDAO = new TaiLieuDAO();
        phieuTraDAO.luuPhieuTra(phieuTra);
        for(LuotTra luottra : luottras) {
            luotTraDAO.luuLuotTra(luottra, phieuTra);
            taiLieuDAO.updateSoLuongTaiLieu(luottra.getLuotMuon().getTaiLieu().getMatl(),
                    luottra.getLuotMuon().getTaiLieu().getSoluong() + 1);
        }
        session.setAttribute("luuPhieuTrasuccess", "Bạn đã lưu phiếu trả thành công!");
        session.setAttribute("luuHoaDonsuccess", "");
        session.setAttribute("luuPhieuMuonsuccess", "");
        String url = "/NVThuVien.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
