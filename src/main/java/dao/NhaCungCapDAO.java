package dao;

import model.NhaCungCap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhaCungCapDAO extends DAO {
    public NhaCungCap getNhaCungCapTheoMa(String mancc) {
        String sql = "select * frome nhacungcap where mancc = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mancc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new NhaCungCap(mancc, rs.getString("ten"), rs.getString("diachi")
                    , rs.getString("sdt"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
