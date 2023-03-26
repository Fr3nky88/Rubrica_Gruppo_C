package Classi;

public class ContattoConIndirizzo extends Indirizzo{
    private String nome;
    private String cognome;
    private String telefono;
    public ContattoConIndirizzo(String nome, String cognome, String telefono, String via, String numCivico, String cap, String locality, String provincia, String indicazioniAgg) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        setVia(via);
        setNumCivico(numCivico);
        setCap(cap);
        setLocality(locality);
        setProvincia(provincia);
        setIndicazioniAgg(indicazioniAgg);
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ContattoConIndirizzo{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", telefono='" + telefono + '\'' +
                getVia() + getNumCivico() + getCap() + getLocality() +
                getProvincia() + getIndicazioniAgg() +
                '}';
    }
}
