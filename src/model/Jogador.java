package model;

public class Jogador {
    private int id_jogador;
    private String nome;
    private int inventario;
    private int cenaAtual;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public int getCenaAtual() {
        return cenaAtual;
    }

    public void setCenaAtual(int cenaAtual) {
        this.cenaAtual = cenaAtual;
    }

    public int getId_jogador() {
        return id_jogador;
    }

    public void setId_jogador(int id_jogador) {
        this.id_jogador = id_jogador;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id_jogador=" + id_jogador +
                ", nome='" + nome + '\'' +
                ", inventario=" + inventario +
                ", cenaAtual=" + cenaAtual +
                '}';
    }
}
