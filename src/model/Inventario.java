package model;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> itens = new ArrayList<>();

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }
    public void mostrarItens() {
        if (itens.isEmpty()) {
            System.out.println("inventario vazio!");
        } else {
            System.out.println("itens disponíveis:");
            for (Item item : itens) {
                System.out.println("- " + item.getNome());
            }
        }
    }
}
