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
                list.add(new NhaCungCap(rs.getString("mancc"), rs.getString("ten"),
                        rs.getString("diachi"), rs.getString("sdt")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
