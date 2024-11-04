package model;

import repository.EscolhaDAO;

import java.sql.SQLException;
import java.util.List;

public class Cena {
    private int id_cena;
    private String descricao;
    private boolean status;

    public Cena(int id_cena, String descricao) {
        this.id_cena = id_cena;
        this.descricao = descricao;
        this.status = false;
    }

    public int getId_cena() { return id_cena; }
    public String getDescricao() { return descricao; }
    public List<Escolha> getOpcoes() throws SQLException {
        return EscolhaDAO.findChoicesByScene(this.id_cena);
    }
}
