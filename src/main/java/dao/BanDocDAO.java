/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BanDoc;
import model.NguoiDung;

/**
 *
 * @author Tien Dat
 */
public class BanDocDAO extends DAO {
    private static List<BanDoc> list = null;
    
    public BanDoc getBanDocTheoNguoiDung(NguoiDung nd) {
       String sql = "select * from bandoc where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nd.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new BanDoc(rs.getString("malop"), nd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
