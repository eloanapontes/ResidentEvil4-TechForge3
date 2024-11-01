package model;

import java.util.List;

public class Cena {
    private int id_cena;
    private String descricao;
    private boolean status;
    private List<Item> itens;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId_cena() {
        return id_cena;
    }

    public void setId_cena(int id_cena) {
        this.id_cena = id_cena;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    //transforma a classe em string?
    @Override
    public String toString() {
        return "Cena{" +
                "id_cena=" + id_cena +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                '}';
    }
}
