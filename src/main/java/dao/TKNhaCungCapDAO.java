package dao;

import model.TKNhaCungCap;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TKNhaCungCapDAO extends DAO {
    public List<TKNhaCungCap> getTKNhaCungCap(LocalDate Ngaybatdau, LocalDate Ngayketthuc) {
        List<TKNhaCungCap> tknhacungcaps = new ArrayList<>();
        String sql = "select SUM(soluong) as tong, mancc, id\n" +
                "from qlthuvien.luotnhap\n" +
                "where ngaynhap\n" +
                "between ? and ?\n" +
                "group by mancc\n" +
                "order by tong desc";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(Ngaybatdau));
            ps.setDate(2, Date.valueOf(Ngayketthuc));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tknhacungcaps.add(new TKNhaCungCap(new NhaCungCapDAO().getNhaCungCapTheoMa(rs.getInt("mancc")),
                    rs.getInt(1)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tknhacungcaps;
    }
}
