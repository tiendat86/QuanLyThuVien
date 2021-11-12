package dao;

import model.HoaDon;
import model.LuotNhap;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LuotNhapDAO extends DAO {

    public void luuLuotNhap(LuotNhap ln, HoaDon hd) {
        String sql = "INSERT INTO `qlthuvien`.`luotnhap` (`id`, `soluong`, `gia`, `ngaynhap`, `mancc`, `matailieu`, " +
                "`idhoadon`) VALUES (?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ln.getId());
            ps.setInt(2, ln.getSoluong());
            ps.setFloat(3, ln.getGia());
            ps.setDate(4, Date.valueOf(ln.getNgaynhap()));
            ps.setInt(5, ln.getNcc().getMancc());
            ps.setString(6, ln.getTailieu().getMatl());
            ps.setInt(7, hd.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LuotMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int maxIDLuotNhap() {
        String sql = "SELECT MAX(id) FROM luotnhap";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LuotNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
