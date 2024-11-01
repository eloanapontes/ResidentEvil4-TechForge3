package repository;

import model.Item;

public class ItemDAO {
    public static Item findItemById(int id){ //receber parametro do ID e retornar instância da classe Item quando o id for encontrado no banco
        return new Item();
    }
}
