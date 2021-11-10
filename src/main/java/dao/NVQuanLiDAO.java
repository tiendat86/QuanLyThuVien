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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BanDoc;
import model.NVQuanLi;
import model.NguoiDung;

/**
 *
 * @author Tien Dat
 */
public class NVQuanLiDAO {
    
    public NVQuanLi getNVQuanLiTheoNguoiDung(NguoiDung nd) {
       String sql = "select * from nvquanli where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nd.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new NVQuanLi(rs.getString("bophan"), nd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
