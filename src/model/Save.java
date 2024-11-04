package model;

public class Save {
    private int idSave;
    private Cena cenaAtual;

    public Cena getCenaAtual() {
        return cenaAtual;
    }

    public void setCenaAtual(Cena cenaAtual) {
        this.cenaAtual = cenaAtual;
    }

    public int getIdSave() {
        return idSave;
    }

    public void setIdSave(int idSave) {
        this.idSave = idSave;
    }

    @Override
    public String toString() {
        return "Save{" +
                "idSave=" + idSave +
                ", cenaAtual=" + cenaAtual +
                '}';
    }
}
