package dao;

import model.PhieuMuon;
import model.PhieuTra;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuTraDAO extends DAO{

    public void luuPhieuTra(PhieuTra pt) {
        String sql = "INSERT INTO `qlthuvien`.`phieutra` (`id`, `idnvthuvien`) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pt.getId());
            ps.setString(2, pt.getNguoiin().getNguoiDung().getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TheBanDocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int maxIDPhieuTra() {
        String sql = "SELECT MAX(id) FROM phieutra";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
