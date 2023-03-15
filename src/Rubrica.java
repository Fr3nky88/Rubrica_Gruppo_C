import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 *  Scrivi un programma Java che simuli una rubrica. L'utente deve essere in grado di aggiungere, cercare, visualizzare e cancellare contatti dalla rubrica.
 *
 */
public class Rubrica {

    public static void main(String[] args) {
        ArrayList<Contatto> rubrica = new ArrayList<>();
        Scanner input = new Scanner(System.in);

    }
}

class Contatto {
    private String nome;
    private String cognome;
    private String telefono;

    public Contatto(String nome, String cognome, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
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

    public String toString() {
        return nome + " " + cognome + ": " + telefono;
    }

}
