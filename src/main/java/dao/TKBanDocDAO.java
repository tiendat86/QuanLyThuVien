package dao;

import model.TKBanDoc;
import model.TheBanDoc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TKBanDocDAO extends DAO {
    public List<TKBanDoc> getTKBanDoc(LocalDate Ngaybatdau, LocalDate Ngayketthuc) {
        List<TKBanDoc> tkbandocs = new ArrayList<>();
        String sql = "SELECT count(mathebandoc) as dem, id, mathebandoc FROM qlthuvien.luotmuon where ngaymuon \n" +
                "between ? and ? \n" +
                "group by mathebandoc \n" +
                "order by dem desc";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(Ngaybatdau));
            ps.setDate(2, Date.valueOf(Ngayketthuc));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tkbandocs.add(new TKBanDoc(new TheBanDocDAO().getTheBanDocTheoMa(rs.getString("mathebandoc")),
                        rs.getInt(1)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tkbandocs;
    }
}
