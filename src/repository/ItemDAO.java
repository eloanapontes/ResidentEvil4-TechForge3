package repository;

import model.Cena;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemDAO {
   // public static Item findItemById(int id){ //receber parametro do ID e retornar instância da classe Item quando o id for encontrado no banco
        //return new Item();
  //  }

    public static Item findItesByScene(int id) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM item WHERE id_item = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        Item item = new Item();

        if (rs.next()){
            item.setId_item(rs.getInt("id_item"));
            item.setDescricaoPositiva(rs.getString("descricaoPositiva"));

        }return item;
    }

}
