package servlet.nvthuvien;

import dao.PhieuTraDAO;
import model.LuotMuon;
import model.LuotTra;
import model.NVThuVien;
import model.PhieuTra;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ChonTaiLieuTraServlet", value = "/chonTaiLieuTra")
public class ChonTaiLieuTraServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        String chons[] = request.getParameterValues("tratailieus");
        String tinhtrang[] = request.getParameterValues("tinhtrangs");
        List<LuotMuon> luotMuons = (List<LuotMuon>) session.getAttribute("luotmuons");
        List<LuotTra> luottras = new ArrayList<>();

        float tongTien = 0;

        for (int i = 0; i < luotMuons.size(); i++) {
            for (int j = 0; j < chons.length; j++) {
                if(luotMuons.get(i).getTaiLieu().getMatl().equals(chons[j])) {
                    int tonthat = 100 - Integer.parseInt(tinhtrang[i]);
                    int tramuon;
                    float tienphat;
                    if(LocalDate.now().getYear() - luotMuons.get(i).getNgayphaitra().getYear() == 1) {
                        tramuon = Math.max(0, LocalDate.now().getDayOfYear() -
                                luotMuons.get(i).getNgayphaitra().getDayOfYear() + 365);
                    } else {
                        tramuon = Math.max(0,LocalDate.now().getDayOfYear() - luotMuons.get(i).getNgayphaitra().getDayOfYear());
                    }
                    System.out.println(luotMuons.get(i).getTaiLieu().getGia());
                    System.out.println(luotMuons.get(i).getTaiLieu().getGia() * (tonthat / 100));
                    tienphat = luotMuons.get(i).getTaiLieu().getGia() * (tonthat / 100f) + tramuon * 3000f;
                    tongTien += tienphat;
                    luottras.add(new LuotTra(LocalDate.now(), "", tienphat, tonthat, luotMuons.get(i)));
                }
            }
        }

        NVThuVien nv = (NVThuVien) session.getAttribute("nhanvien");
        PhieuTraDAO phieuTraDAO = new PhieuTraDAO();
        PhieuTra phieutra = new PhieuTra(phieuTraDAO.maxIDPhieuTra() + 1, luottras, tongTien, nv);

        session.setAttribute("luottras", luottras);
        session.setAttribute("phieutra", phieutra);
        String url = "/PhieuTra.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
