package servlet.nvthuvien;

import dao.HoaDonDAO;
import dao.LuotNhapDAO;
import dao.TaiLieuDAO;
import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LuuHoaDonServlet", value = "/luuHoaDon")
public class LuuHoaDonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        List<LuotNhap> luotnhaps = (List<LuotNhap>) session.getAttribute("luotnhaps");
        HoaDon hoaDon = (HoaDon) session.getAttribute("hoadon");
        HoaDonDAO hoaDonDAO = new HoaDonDAO();
        LuotNhapDAO luotNhapDAO = new LuotNhapDAO();
        TaiLieuDAO taiLieuDAO = new TaiLieuDAO();
        hoaDonDAO.luuHoaDon(hoaDon);
        for (int i = 0; i < luotnhaps.size(); i++) {
            luotNhapDAO.luuLuotNhap(luotnhaps.get(i), hoaDon);
            taiLieuDAO.updateSoLuongTaiLieu(luotnhaps.get(i).getTailieu().getMatl(),
                    luotnhaps.get(i).getTailieu().getSoluong() + luotnhaps.get(i).getSoluong());
        }
        session.setAttribute("luuHoaDonsuccess", "Bạn đã lưu hóa đơn thành công!");
        String url = "/NVThuVien.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        NhaCungCap ncc = (NhaCungCap) session.getAttribute("nhacungcap");
        NVThuVien nv = (NVThuVien) session.getAttribute("nhanvien");
        List<TaiLieu> tailieus = (List<TaiLieu>) session.getAttribute("tailieus");
        List<LuotNhap> luotnhaps = new ArrayList<>();
        String []soluongs = request.getParameterValues("soluongs");
        String []dongias = request.getParameterValues("dongias");

        float tongtien = 0;
        int tongsoluong = 0;
        LuotNhapDAO luotNhapDAO = new LuotNhapDAO();
        int inc = luotNhapDAO.maxIDLuotNhap() + 1;
        for (int i = 0; i < tailieus.size(); i++) {
            tongtien +=  Float.parseFloat(dongias[i]) * Integer.parseInt(soluongs[i]);
            tongsoluong += Integer.parseInt(soluongs[i]);
            luotnhaps.add(new LuotNhap(ncc, tailieus.get(i), Integer.parseInt(soluongs[i]),
                    Float.parseFloat(dongias[i]) * Integer.parseInt(soluongs[i]),
                    LocalDate.now(), inc));
            inc++;
        }

        HoaDon hoaDon = new HoaDon(new HoaDonDAO().maxIDHoaDon() + 1, tongtien, tongsoluong, luotnhaps, nv);
        session.setAttribute("luotnhaps", luotnhaps);
        session.setAttribute("hoadon", hoaDon);
        String url = "/HoaDon.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
