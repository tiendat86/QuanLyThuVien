/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LuotMuon;
import model.NVThuVien;
import model.PhieuMuon;
import model.PhieuTra;

/**
 *
 * @author dangt
 */
public class PhieuMuonDAO extends DAO {
    
    public void luuPhieuMuon(PhieuMuon pm) {
        String sql = "INSERT INTO `qlthuvien`.`phieumuon` (`id`, `idnvthuvien`) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pm.getId());
            ps.setString(2, pm.getNguoiin().getNguoiDung().getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TheBanDocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int maxIDPhieuMuon() {
        String sql = "SELECT MAX(id) FROM phieumuon";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
