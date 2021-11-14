package dao;

import model.HoaDon;
import model.LuotNhap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonDAO extends DAO {

    public void luuHoaDon(HoaDon hd) {
        String sql = "INSERT INTO `qlthuvien`.`hoadon` (`id`, `idnvthuvien`) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, hd.getId());
            ps.setString(2, hd.getNguoiin().getNguoiDung().getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int maxIDHoaDon() {
        String sql = "SELECT MAX(id) FROM hoadon";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public HoaDon getHoaDonTheoLuotNhap(int idLuotNhap) {
        List<LuotNhap> luotnhaps = new ArrayList<>();
        String sql = "select luotnhap.*, idnvthuvien \n" +
                "from luotnhap inner join hoadon\n" +
                "on luotnhap.idhoadon = hoadon.id\n" +
                "where idhoadon = \n" +
                "(select idhoadon from luotnhap where id = ?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idLuotNhap);
            ResultSet rs = ps.executeQuery();
            int idHD = 0, tongSoluong = 0;
            float tongTien = 0;
            String idNVThuVien = null;
            while (rs.next()) {
                luotnhaps.add(new LuotNhap(new NhaCungCapDAO().getNhaCungCapTheoMa(rs.getInt("mancc")),
                        new TaiLieuDAO().getTaiLieuTheoMa(rs.getString("matailieu")),
                        rs.getInt("soluong"), rs.getFloat("gia"),
                        rs.getDate("ngaynhap").toLocalDate(), rs.getInt("id")));
                idHD = rs.getInt("idhoadon");
                idNVThuVien = rs.getString("idnvthuvien");
                tongTien += rs.getFloat("gia");
                tongSoluong += rs.getInt("soluong");
            }
            return new HoaDon(idHD ,tongTien, tongSoluong, luotnhaps,
                    new NVThuVienDAO().getNVThuVienTheoNguoiDung(new NguoiDungDAO().getNguoiDungTheoMa(idNVThuVien)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
