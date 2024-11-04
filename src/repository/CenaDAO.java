package repository;

import model.Cena;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CenaDAO {
    public static Cena findCenaById(int id) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM Cena WHERE ID_Cena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Cria uma nova instância de Cena com os dados do ResultSet
            int cenaId = rs.getInt("ID_Cena");
            String descricao = rs.getString("Descricao");
            Cena cena = new Cena(cenaId, descricao);
            return cena;
        } else {
            return null;
        }
    }


}
