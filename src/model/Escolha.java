package model;

public class Escolha {
    private int id_escolha;
    private String descricao;
    private String resultado;
    private int cenaId;

    private String use_descricao;
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

    public String getUse_descricao() {
        return use_descricao;
    }

    public void setUse_descricao(String use_descricao) {
        this.use_descricao = use_descricao;
    }

    @Override
    public String toString() {
        return "Escolha{" +
                "id_escolha=" + id_escolha +
                ", descricao='" + descricao + '\'' +
                ", resultado='" + resultado + '\'' +
                ", cenaId=" + cenaId +
                ", use_descricao='" + use_descricao + '\'' +
                '}';
    }
}
