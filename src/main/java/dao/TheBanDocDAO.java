/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BanDoc;
import model.TheBanDoc;

/**
 *
 * @author dangt
 */
public class TheBanDocDAO extends DAO {
    public void luuTheBanDoc(TheBanDoc tbd) {
        String sql = "INSERT INTO `qlthuvien`.`thebandoc` (`mathe`, `loaithe`, `idbandoc`) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tbd.getMathe());           
            ps.setString(2, tbd.getLoaithe());
            ps.setString(3, tbd.getBanDoc().getNguoiDung().getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TheBanDocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public TheBanDoc getTheBanDocTheoMa(String ma) {
        String sql = "Select * from thebandoc where mathe = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                                
                return new TheBanDoc(rs.getString("mathe"), rs.getString("loaithe"), 
                        new BanDocDAO().getBanDocTheoNguoiDung(new NguoiDungDAO().getNguoiDungTheoMa(rs.getString("idbandoc"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheBanDocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public TheBanDoc getTheBanDocTheoBanDoc(BanDoc bd) {
        String sql = "Select * from thebandoc where idbandoc = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, bd.getNguoiDung().getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                return new TheBanDoc(rs.getString("mathe"), rs.getString("loaithe"), bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheBanDocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
