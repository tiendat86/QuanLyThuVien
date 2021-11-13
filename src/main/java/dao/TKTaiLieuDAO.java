package dao;

import model.TKTaiLieu;
import model.TaiLieu;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TKTaiLieuDAO extends DAO {
    public List<TKTaiLieu> getTKTaiLieu(LocalDate Ngaybatdau, LocalDate Ngayketthuc) {
        List<TKTaiLieu> tktailieus = new ArrayList<>();
        String sql = "SELECT count(matailieu) as dem, id, matailieu FROM qlthuvien.luotmuon where ngaymuon \n" +
                "between ? and ? \n" +
                "group by matailieu \n" +
                "order by dem desc";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(Ngaybatdau));
            ps.setDate(2, Date.valueOf(Ngayketthuc));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tktailieus.add(new TKTaiLieu(new TaiLieuDAO().getTaiLieuTheoMa(rs.getString("matailieu")),
                    rs.getInt(1)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tktailieus;
    }
}
