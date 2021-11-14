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

    public PhieuMuon getPhieuMuonTheoLuotMuon(int idluotmuon) {
        List<LuotMuon> luotmuons = new ArrayList<>();
        String sql = "select luotmuon.*, idnvthuvien \n" +
                "from luotmuon inner join phieumuon\n" +
                "on luotmuon.phieumuonid = phieumuon.id\n" +
                "where phieumuonid = \n" +
                "(select phieumuonid from luotmuon where id = ?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idluotmuon);
            ResultSet rs = ps.executeQuery();
            int idPM = 0;
            String idNVThuVien = null;
            while (rs.next()) {
                luotmuons.add(new LuotMuon(rs.getInt("id"),
                        new TaiLieuDAO().getTaiLieuTheoMa(rs.getString("matailieu")),
                        new TheBanDocDAO().getTheBanDocTheoMa(rs.getString("mathebandoc")),
                        rs.getDate("ngaymuon").toLocalDate(), rs.getDate("ngayphaitra").toLocalDate(),
                        rs.getString("mota")));
                idPM = rs.getInt("phieumuonid");
                idNVThuVien = rs.getString("idnvthuvien");
            }
            return new PhieuMuon(idPM ,luotmuons, luotmuons.get(0).getNgaymuon(), new NVThuVienDAO().
                    getNVThuVienTheoNguoiDung(new NguoiDungDAO().getNguoiDungTheoMa(idNVThuVien)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
