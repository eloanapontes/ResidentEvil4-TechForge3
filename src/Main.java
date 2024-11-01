import model.Cena;
import model.Item;
import repository.CenaDAO;
import repository.ItemDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Cena cena = CenaDAO.findCenaById(1);
            Item item = ItemDAO.findItesByScene(1);


            System.out.println(item.toString());
            System.out.println(cena.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}