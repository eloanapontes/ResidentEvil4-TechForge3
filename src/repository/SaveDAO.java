package repository;

import model.Save;

import java.sql.*;

public class SaveDAO {

    public static Save novoJogo(int idCenaAtual) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO saves(id_cena_atual) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, idCenaAtual); // Define o valor de idCenaAtual
        stmt.executeUpdate();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Save save = new Save();
        if (generatedKeys.next()) {
            save.setIdSave(generatedKeys.getInt(1));
            save.setCenaAtual(CenaDAO.findCenaById(idCenaAtual));
        }
        return save;
    }
}


