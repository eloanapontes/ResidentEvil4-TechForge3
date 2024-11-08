package repository;

import model.Escolha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EscolhaDAO {

    public static List<Escolha> findChoicesByScene(int cenaId) throws SQLException {
        List<Escolha> escolhas = new ArrayList<>();
        Connection conn = Mysql.getConnection();

        // inner join p retornar id cena e id escolha
        String sql = "SELECT e.ID_Escolha, e.Descricao AS EscolhaDescricao, e.Resultado, e.use_descricao, c.Descricao AS CenaDescricao " +
                "FROM Escolha e " +
                "INNER JOIN Cena c ON e.Cena_ID = c.ID_Cena " +
                "WHERE e.Cena_ID = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, cenaId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Escolha escolha = new Escolha();
            escolha.setId_escolha(rs.getInt("ID_Escolha"));
            escolha.setDescricao(rs.getString("EscolhaDescricao"));
            escolha.setResultado(rs.getString("Resultado"));
            escolha.setUse_descricao(rs.getString("use_descricao"));

            String cenaDescricao = rs.getString("CenaDescricao");
            System.out.println("Cena Descrição: " + cenaDescricao);

            escolhas.add(escolha);
        }

        stmt.close();
        conn.close();

        return escolhas;
    }



    // add escolha no bd
    public static void inserirEscolha(String descricao, String resultado, int cenaId, String use_descricao) throws SQLException {
        if (!escolhaJaExistente(descricao, cenaId)) {
            Connection connection = Mysql.getConnection();
            String sql = "INSERT INTO Escolha (Descricao, Resultado, Cena_ID, use_descricao) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, descricao);
            ps.setString(2, resultado);
            ps.setInt(3, cenaId);
            ps.setString(4,use_descricao);
            ps.executeUpdate();
        }
    }

    private static boolean escolhaJaExistente(String descricao, int cenaId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Escolha WHERE Descricao = ? AND Cena_ID = ?";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, descricao);
            ps.setInt(2, cenaId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // true se a escolha existir
            }
        }
        return false;
    }

}
