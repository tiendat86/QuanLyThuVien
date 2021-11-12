/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.nvthuvien;

import dao.LuotMuonDAO;
import dao.PhieuMuonDAO;
import dao.TaiLieuDAO;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LuotMuon;
import model.NVThuVien;
import model.PhieuMuon;
import model.TaiLieu;
import model.TheBanDoc;

/**
 *
 * @author dangt
 */
public class LuuPhieuMuonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        
        List<LuotMuon> luotmuons = (List<LuotMuon>) session.getAttribute("luotmuons");
        PhieuMuon phieumuon = (PhieuMuon) session.getAttribute("phieumuon");
        TaiLieuDAO tldao = new TaiLieuDAO();
        LuotMuonDAO lmdao = new LuotMuonDAO();
        PhieuMuonDAO pmdao = new PhieuMuonDAO();
        pmdao.luuPhieuMuon(phieumuon);
        for(LuotMuon luotmuon : luotmuons) {
            lmdao.luuLuotMuon(luotmuon, phieumuon);
            tldao.updateSoLuongTaiLieu(luotmuon.getTaiLieu().getMatl(), luotmuon.getTaiLieu().getSoluong() - 1);
        }
        session.setAttribute("luuPhieuMuonsuccess", "Bạn đã lưu phiếu mượn thành công!");
        String url = "/NVThuVien.jsp";
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
        
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngaymuon = LocalDate.now();   
         LocalDate ngaytra = LocalDate.parse(request.getParameter("ngaytra"), formatter);

        TheBanDoc thebd = (TheBanDoc) session.getAttribute("thebandoc");
        NVThuVien nv = (NVThuVien) session.getAttribute("nhanvien");
        List<TaiLieu> tailieus = (List<TaiLieu>) session.getAttribute("tailieus");
        List<LuotMuon> luotmuons = new ArrayList<>();
        int inc = new LuotMuonDAO().maxIDLuotMuon() + 1;
        for(TaiLieu tailieu : tailieus) {
            luotmuons.add(new LuotMuon(inc ,tailieu, thebd, ngaymuon, ngaytra, ""));
            inc++;
        }
        PhieuMuon phieumuon = new PhieuMuon(new PhieuMuonDAO().maxIDPhieuMuon() + 1,luotmuons, ngaytra, nv);
        session.setAttribute("luotmuons", luotmuons);
        session.setAttribute("phieumuon", phieumuon);
        String url = "/PhieuMuon.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
