package dao;

import model.NhaCungCap;
import model.TaiLieu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhaCungCapDAO extends DAO {
    public List<NhaCungCap> getNhaCungCapTheoTen(String ten) {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "select * from nhacungcap where ten like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhaCungCap(rs.getInt("mancc"), rs.getString("ten"),
                        rs.getString("diachi"), rs.getString("sdt")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public NhaCungCap getNhaCungCapTheoMa(String ma) {
        String sql = "select * from nhacungcap where mancc = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new NhaCungCap(rs.getInt("mancc"), rs.getString("ten"),
                        rs.getString("diachi"), rs.getString("sdt"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void themNhaCungCap(NhaCungCap ncc) {
        String sql = "INSERT INTO `qlthuvien`.`nhacungcap` (`mancc`, `ten`, `diachi`, `sdt`) " +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ncc.getMancc());
            ps.setString(2, ncc.getTen());
            ps.setString(3, ncc.getDiachi());
            ps.setString(4, ncc.getSdt());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int maxIDNhaCungCap() {
        String sql = "select max(mancc) from nhacungcap";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
