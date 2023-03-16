import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 *  Scrivi un programma Java che simuli una rubrica. L'utente deve essere in grado di aggiungere, cercare, visualizzare e cancellare contatti dalla rubrica.
 *
 */
public class Rubrica {

    public static void main(String[] args) {
        List<Contatto> rubrica = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        boolean running = true;

        System.out.println("" +
                "         _      _                  _               _            _           _             _                    _              _      _                  _          _          _                 _      \n" +
                "        /\\ \\   /\\_\\               / /\\            /\\ \\         /\\ \\       /\\ \\           / /\\                 /\\ \\           /\\ \\   /\\_\\               /\\ \\       /\\ \\       /\\ \\             /\\ \\     \n" +
                "       /  \\ \\ / / /         _    / /  \\          /  \\ \\        \\ \\ \\     /  \\ \\         / /  \\               /  \\ \\         /  \\ \\ / / /         _    /  \\ \\     /  \\ \\     /  \\ \\           /  \\ \\    \n" +
                "      / /\\ \\ \\\\ \\ \\__      /\\_\\ / / /\\ \\        / /\\ \\ \\       /\\ \\_\\   / /\\ \\ \\       / / /\\ \\             / /\\ \\_\\       / /\\ \\ \\\\ \\ \\__      /\\_\\ / /\\ \\ \\   / /\\ \\ \\   / /\\ \\ \\         / /\\ \\ \\   \n" +
                "     / / /\\ \\_\\\\ \\___\\    / / // / /\\ \\ \\      / / /\\ \\_\\     / /\\/_/  / / /\\ \\ \\     / / /\\ \\ \\           / / /\\/_/      / / /\\ \\_\\\\ \\___\\    / / // / /\\ \\_\\ / / /\\ \\_\\ / / /\\ \\ \\       / / /\\ \\ \\  \n" +
                "    / / /_/ / / \\__  /   / / // / /\\ \\_\\ \\    / / /_/ / /    / / /    / / /  \\ \\_\\   / / /  \\ \\ \\         / / / ______   / / /_/ / / \\__  /   / / // / /_/ / // / /_/ / // / /  \\ \\_\\     / / /  \\ \\_\\ \n" +
                "   / / /__\\/ /  / / /   / / // / /\\ \\ \\___\\  / / /__\\/ /    / / /    / / /    \\/_/  / / /___/ /\\ \\       / / / /\\_____\\ / / /__\\/ /  / / /   / / // / /__\\/ // / /__\\/ // / /   / / /    / / /    \\/_/ \n" +
                "  / / /_____/  / / /   / / // / /  \\ \\ \\__/ / / /_____/    / / /    / / /          / / /_____/ /\\ \\     / / /  \\/____ // / /_____/  / / /   / / // / /_____// / /_____// / /   / / /    / / /          \n" +
                " / / /\\ \\ \\   / / /___/ / // / /____\\_\\ \\  / / /\\ \\ \\  ___/ / /__  / / /________  / /_________/\\ \\ \\   / / /_____/ / // / /\\ \\ \\   / / /___/ / // / /      / / /      / / /___/ / /    / / /________   \n" +
                "/ / /  \\ \\ \\ / / /____\\/ // / /__________\\/ / /  \\ \\ \\/\\__\\/_/___\\/ / /_________\\/ / /_       __\\ \\_\\ / / /______\\/ // / /  \\ \\ \\ / / /____\\/ // / /      / / /      / / /____\\/ /    / / /_________\\  \n" +
                "\\/_/    \\_\\/ \\/_________/ \\/_____________/\\/_/    \\_\\/\\/_________/\\/____________/\\_\\___\\     /____/_/ \\/___________/ \\/_/    \\_\\/ \\/_________/ \\/_/       \\/_/       \\/_________/     \\/____________/  \n" +
                "                                                                                                                                                                                                      "
        );

        while (running) {
            System.out.println("Seleziona un'operazione:");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Cerca contatto");
            System.out.println("3. Visualizza tutti i contatti");
            System.out.println("4. Cancella contatto");
            System.out.println("0. Esci");

            int scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    running = false;
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Errore input non valido!");
            }
        }

    }
}

/**
 * Contatto della rubrica
 *
 *
 */
class Contatto {
    private String nome;
    private String cognome;
    private String telefono;

    public Contatto(String nome, String cognome, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
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

    public String toString() {
        return nome + " " + cognome + ": " + telefono;
    }

}
