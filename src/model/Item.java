package model;

public class Item {
    private int id_item;
    private String nome;
    private String descricaoPositiva;
    private String descricaoNegativa;
    private String comandoCorreto;
    private int idCenaAtual;
    private int idCenaDestino;

    // Getters e Setters

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoPositiva() {
        return descricaoPositiva;
    }

    public void setDescricaoPositiva(String descricaoPositiva) {
        this.descricaoPositiva = descricaoPositiva;
    }

    public String getDescricaoNegativa() {
        return descricaoNegativa;
    }

    public void setDescricaoNegativa(String descricaoNegativa) {
        this.descricaoNegativa = descricaoNegativa;
    }

    public String getComandoCorreto() {
        return comandoCorreto;
    }

    public void setComandoCorreto(String comandoCorreto) {
        this.comandoCorreto = comandoCorreto;
    }

    public int getIdCenaAtual() {
        return idCenaAtual;
    }

    public void setIdCenaAtual(int idCenaAtual) {
        this.idCenaAtual = idCenaAtual;
    }

    public int getIdCenaDestino() {
        return idCenaDestino;
    }

    public void setIdCenaDestino(int idCenaDestino) {
        this.idCenaDestino = idCenaDestino;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id_item=" + id_item +
                ", nome='" + nome + '\'' +
                ", descricaoPositiva='" + descricaoPositiva + '\'' +
                ", descricaoNegativa='" + descricaoNegativa + '\'' +
                ", comandoCorreto='" + comandoCorreto + '\'' +
                ", idCenaAtual=" + idCenaAtual +
                ", idCenaDestino=" + idCenaDestino +
                '}';
    }
}
