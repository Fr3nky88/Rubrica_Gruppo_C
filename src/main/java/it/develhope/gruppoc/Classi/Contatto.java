package it.develhope.gruppoc.Classi;

import java.math.BigInteger;

public class Contatto {

    private BigInteger id;
    private String nome;
    private String cognome;
    private String telefono;

    private String email;

    public Contatto(String nome, String cognome, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public Contatto() {

    }

    /**
     * Metodo che restituisce il nome memorizzato all'interno del contatto
     * @return String nome
     */
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

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return nome + " " + cognome + ": " + telefono;
    }

}