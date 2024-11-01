package model;

public class Inventario {
    private int id_inventario;
    private int id_jogador;
    private int id_item;

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getId_jogador() {
        return id_jogador;
    }

    public void setId_jogador(int id_jogador) {
        this.id_jogador = id_jogador;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "id_inventario=" + id_inventario +
                ", id_jogador=" + id_jogador +
                ", id_item=" + id_item +
                '}';
    }
}
