package dao;

import model.NhaCungCap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO extends DAO {
    public List<NhaCungCap> getNhaCungCapTheoTen(String ten) {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "select * frome nhacungcap where ten like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhaCungCap(rs.getString("mancc"), rs.getString("ten"), rs.getString("diachi")
                    , rs.getString("sdt")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
