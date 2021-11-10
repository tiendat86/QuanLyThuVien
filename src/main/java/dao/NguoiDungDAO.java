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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NguoiDung;
import model.TheBanDoc;

/**
 *
 * @author Tien Dat
 */
public class NguoiDungDAO extends DAO{
    private static List<NguoiDung> list = null;
    
    public NguoiDung dangnhap(String tentaikhoan, String matkhau) {
        String sql = "select * from NguoiDung where tentaikhoan = ? and matkhau = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tentaikhoan);
            ps.setString(2, matkhau);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new NguoiDung(rs.getString("id"), rs.getString("tentaikhoan"), rs.getString("matkhau"),
                        rs.getString("ten"), rs.getString("sdt"), rs.getString("diachi"), rs.getDate("ngaysinh"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public NguoiDung getNguoiDungTheoMa(String ma) {
        String sql = "Select * from nguoidung where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                               
                return new NguoiDung(rs.getString("id"), rs.getString("tentaikhoan"), rs.getString("matkhau"),
                        rs.getString("ten"), rs.getString("sdt"), rs.getString("diachi"), rs.getDate("ngaysinh"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheBanDocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
