package dao;

import model.LuotTra;
import model.PhieuTra;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LuotTraDAO extends DAO {

    public void luuLuotTra(LuotTra luotTra, PhieuTra phieuTra) {
        String sql = "INSERT INTO `qlthuvien`.`luottra` (`idluotmuon`, `ngaytra`, `tonthat`, `mota`, `idphieutra`)" +
                " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, luotTra.getLuotMuon().getId());
            ps.setDate(2, Date.valueOf(luotTra.getNgaytra()));
            ps.setInt(3, luotTra.getTonthat());
            ps.setString(4, luotTra.getMota());
            ps.setInt(5, phieuTra.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LuotTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}