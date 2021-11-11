/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LuotMuon;
import model.PhieuMuon;
import model.TheBanDoc;

/**
 *
 * @author dangt
 */
public class LuotMuonDAO extends DAO {
    
    public void luuLuotMuon(LuotMuon lm, PhieuMuon pm) {
        String sql = "INSERT INTO `qlthuvien`.`luotmuon` (`id`, `ngaymuon`, `ngayphaitra`, `mota`, `mathebandoc`, `matailieu`, `phieumuonid`) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, lm.getId());
            ps.setDate(2, Date.valueOf(lm.getNgaymuon()));
            ps.setDate(3, Date.valueOf(lm.getNgayphaitra()));
            ps.setString(4, lm.getMota());
            ps.setString(5, lm.getTheBanDoc().getMathe());
            ps.setString(6, lm.getTaiLieu().getMatl());
            ps.setInt(7, pm.getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LuotMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int maxIDLuotMuon() {
        String sql = "SELECT MAX(id) FROM luotmuon";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LuotMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<LuotMuon> getLuotMuonsChuaTraTheoMaTheBD(String ma) {
        String sql = "select * from luotmuon where mathebandoc = ? and id not in (select idluotmuon from luottra);";
        List<LuotMuon> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LuotMuon(rs.getInt("id"),
                        new TaiLieuDAO().getTaiLieuTheoMa(rs.getString("matailieu")),
                        new TheBanDocDAO().getTheBanDocTheoMa(rs.getString("mathebandoc")),
                        rs.getDate("ngaymuon").toLocalDate(), rs.getDate("ngayphaitra").toLocalDate(),
                        rs.getString("mota")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
