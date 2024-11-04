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
        String sql = "SELECT * FROM Escolha WHERE Cena_ID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, cenaId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Escolha escolha = new Escolha();
            escolha.setId_escolha(rs.getInt("ID_Escolha"));
            escolha.setDescricao(rs.getString("Descricao"));
            escolha.setResultado(rs.getString("Resultado"));
            escolhas.add(escolha);
        }
        return escolhas;
    }

    // Método para inserir uma escolha no banco de dados
    public static void inserirEscolha(String descricao, String resultado, int cenaId) throws SQLException {
        if (!escolhaJaExistente(descricao, cenaId)) {
            Connection connection = Mysql.getConnection();
            String sql = "INSERT INTO Escolha (Descricao, Resultado, Cena_ID) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, descricao);
            ps.setString(2, resultado);
            ps.setInt(3, cenaId);
            ps.executeUpdate();
        }
    }

    // Método para verificar se a escolha já existe no banco de dados
    private static boolean escolhaJaExistente(String descricao, int cenaId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Escolha WHERE Descricao = ? AND Cena_ID = ?";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, descricao);
            ps.setInt(2, cenaId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; //  true se a escolha existir
            }
        }
        return false;
    }
}
