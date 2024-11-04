package repository;

import model.Cena;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    public static List<Item> findItemsByScene(int id_item) throws SQLException {
        String sql = "SELECT * FROM item WHERE id = ?";
        List<Item> itens = new ArrayList<>();

        try (Connection conn = Mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_item);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item();
                    item.setId_item(rs.getInt("id_item"));
                    item.setNome(rs.getString("nome"));
                    item.setDescricaoPositiva(rs.getString("descricaoPositiva"));
                    item.setDescricaoNegativa(rs.getString("descricaoNegativa"));
                    item.setComandoCorreto(rs.getString("comandoCorreto"));
                    item.setIdCenaAtual(rs.getInt("idCenaAtual"));
                    item.setIdCenaDestino(rs.getInt("idCenaDestino"));
                    itens.add(item);
                }
            }
        }

        return itens;
    }

}

