package model;

public class Escolha {
    private int id_escolha;
    private String descricao;
    private String resultado;
    private int cenaId;

    // Getters e Setters
    public int getId_escolha() {
        return id_escolha;
    }

    public void setId_escolha(int id_escolha) {
        this.id_escolha = id_escolha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getCenaId() {
        return cenaId;
    }

    public void setCenaId(int cenaId) {
        this.cenaId = cenaId;
    }

    @Override
    public String toString() {
        return "Escolha{" +
                "id_escolha=" + id_escolha +
                ", descricao='" + descricao + '\'' +
                ", resultado='" + resultado + '\'' +
                ", cenaId=" + cenaId +
                '}';
    }
}
