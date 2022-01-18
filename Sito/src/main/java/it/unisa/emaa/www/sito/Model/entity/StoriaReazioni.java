package it.unisa.emaa.www.sito.Model.entity;

public class StoriaReazioni {
    public Storia getStoria() {
        return storia;
    }

    public void setStoria(Storia storia) {
        this.storia = storia;
    }

    public boolean isReazionata() {
        return reazionata;
    }

    public void setReazionata(boolean reazionata) {
        this.reazionata = reazionata;
    }

    private Storia storia;

    @Override
    public String toString() {
        return "StoriaReazioni{" +
                "storia=" + storia +
                ", reazionata=" + reazionata +
                '}';
    }

    private boolean reazionata;

}
