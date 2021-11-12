package dao;

import model.HoaDon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
