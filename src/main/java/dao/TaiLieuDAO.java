/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.NhaCungCap;
import model.TaiLieu;

/**
 *
 * @author Tien Dat
 */
public class TaiLieuDAO extends DAO {
    private static List<TaiLieu> listTL = null;
            
    public List<TaiLieu> getTaiLieuTheoTen(String ten) {
        List<TaiLieu> list = new ArrayList<>();
        String sql = "select * from tailieu where ten like ?"; 
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TaiLieu(rs.getString("matailieu"), rs.getString("ten"), rs.getFloat("gia"), 
                        rs.getString("tacgia"),rs.getString("nxb"), rs.getInt("soluong")));               
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public TaiLieu getTaiLieuTheoMa(String ma) {
        String sql = "select * from tailieu where matailieu = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                return new TaiLieu(ma, rs.getString("ten"), rs.getFloat("gia"), rs.getString("tacgia"), rs.getString("nxb"), rs.getInt("soluong"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateSoLuongTaiLieu(String ma, int soluong) {
        String sql = "UPDATE `qlthuvien`.`tailieu` SET `soluong` = ? WHERE (`matailieu` = ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, soluong);
            ps.setString(2, ma);
             ps.executeUpdate();

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateGiaTaiLieu(String ma, float gia) {
        String sql = "UPDATE `qlthuvien`.`tailieu` SET `gia` = ? WHERE (`matailieu` = ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1, gia);
            ps.setString(2, ma);
            ps.executeUpdate();

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void themTaiLieu(TaiLieu tl) {
        String sql = "INSERT INTO `qlthuvien`.`tailieu` (`matailieu`, `ten`, `gia`, `nxb`, `soluong`, `tacgia`) " +
                "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tl.getMatl());
            ps.setString(2, tl.getTen());
            ps.setFloat(3, tl.getGia());
            ps.setString(4, tl.getNxb());
            ps.setInt(5, tl.getSoluong());
            ps.setString(6, tl.getTacgia());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
