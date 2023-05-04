package it.develhope.gruppoc.Classi;

public class Indirizzo {
    private String via = null;
    private String numCivico = null;
    private String cap = null;
    private String locality = null;
    private String provincia = null;
    private String indicazioniAgg = "";

    public Indirizzo() {}
    public Indirizzo(String via, String numCivico, String cap, String locality, String provincia, String indicazioniAgg) {
        this.via = via;
        this.numCivico = numCivico;
        this.cap = cap;
        this.locality = locality;
        this.provincia = provincia;
        this.indicazioniAgg = indicazioniAgg;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getNumCivico() {
        return numCivico;
    }

    public void setNumCivico(String numCivico) {
        this.numCivico = numCivico;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getIndicazioniAgg() {
        return indicazioniAgg;
    }

    public void setIndicazioniAgg(String indicazioniAgg) {
        this.indicazioniAgg = indicazioniAgg;
    }

    @Override
    public String toString() {
        return "Indirizzo{" +
                "via='" + via + '\'' +
                ", numCivico='" + numCivico + '\'' +
                ", cap='" + cap + '\'' +
                ", locality='" + locality + '\'' +
                ", provincia='" + provincia + '\'' +
                ", indicazioniAgg='" + indicazioniAgg + '\'' +
                '}';
    }
}
