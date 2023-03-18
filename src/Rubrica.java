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
                    System.out.println("\n Aggiungi il tuo contatto!");
                    System.out.println("\n Digita il nome!");
                    String nome = input.next();

                    System.out.println("\n Digita il cognome!");
                    String cognome = input.next();

                    System.out.println("\n Digita ora il numero!");
                    String numero= input.next();

                    Contatto contatto = new Contatto(nome, cognome, numero);

                    rubrica.add(contatto);

                    System.out.println("\n Contatto aggiunto con successo!");
                    break;
                case 2:
                    //Ricerca del contatto
                    System.out.println("Vuoi cercare per: nome, cognome o numero?");
                    String parametro = input.next();
                    if ("nome".contains(parametro.toLowerCase())){
                        System.out.println("Digitare il nome del contatto:");
                        parametro = input.next();
                        for (Contatto i : rubrica) {
                            if (parametro.toLowerCase().equals(i.getNome().toLowerCase())) {
                                System.out.println(i);
                            }
                        }
                    } else if ("cognome".contains(parametro.toLowerCase())){
                        System.out.println("Digitare il cognome del contatto:");
                        parametro = input.next();
                        for (Contatto i : rubrica) {
                            if (parametro.toLowerCase().equals(i.getCognome().toLowerCase())) {
                                System.out.println(i);
                            }
                        }
                    } else if ("numero".contains(parametro.toLowerCase())){
                        System.out.println("Digitare il numero o parte numerodel contatto:");
                        parametro = input.next();
                        for (Contatto i : rubrica) {
                            if (i.getTelefono().contains(parametro)) {
                                System.out.println(i);
                            }
                        }
                    }
                    break;
                case 3:
                    int i2 = 1;
                    for (Contatto contatto1 : rubrica) {
                        System.out.println("Contatto: " + i2 + "-" + contatto1);
                        i2++;
                    }
                    break;
                case 4:
                    System.out.println("Ricerca del contatto da eliminare...");
                    System.out.println("Vuoi cercare per: nome, cognome o numero?");
                    parametro = input.next();
                    if ("nome".contains(parametro.toLowerCase())){
                        System.out.println("Digitare il nome del contatto:");
                        parametro = input.next();
                        int indiceContatto;
                        boolean sure = false;
                        while (!sure) {
                            System.out.println("Scegli il contatto da eliminare digitando il suo indice...");
                            for (Contatto i : rubrica) {
                                if (parametro.toLowerCase().equals(i.getNome().toLowerCase())) {
                                    System.out.println(i + "\nCon indice: " + rubrica.indexOf(i));
                                    System.out.println(" ");
                                }
                            }
                            indiceContatto = input.nextInt();
                            System.out.println("Procedere all'eliminazione? Inserire: true/false");
                            sure = input.nextBoolean();
                            if (sure) {
                                System.out.println("Contatto: " + rubrica.get(indiceContatto) + " rimosso consuccesso!");
                                rubrica.remove(indiceContatto);
                            } else {
                                System.out.println("Vuoi annullare l'operazione elimina contatto? Inserire: true/false");
                                sure = input.nextBoolean();
                            }
                        }
                    } else if ("cognome".contains(parametro.toLowerCase())){
                        System.out.println("Digitare il cognome del contatto:");
                        parametro = input.next();
                        int indiceContatto;
                        boolean sure = false;
                        while (!sure) {
                            System.out.println("Scegli il contatto da eliminare digitando il suo indice...");
                            for (Contatto i : rubrica) {
                                if (parametro.toLowerCase().equals(i.getCognome().toLowerCase())) {
                                    System.out.println(i + "\nCon indice: " + rubrica.indexOf(i));
                                    System.out.println(" ");
                                }
                            }
                            indiceContatto = input.nextInt();
                            System.out.println("Procedere all'eliminazione? Inserire: true/false");
                            sure = input.nextBoolean();
                            if (sure) {
                                System.out.println("Contatto: " + rubrica.get(indiceContatto) + " rimosso consuccesso!");
                                rubrica.remove(indiceContatto);
                            } else {
                                System.out.println("Vuoi annullare l'operazione elimina contatto? Inserire: true/false");
                                sure = input.nextBoolean();
                            }
                        }
                    } else if ("numero".contains(parametro.toLowerCase())){
                        System.out.println("Digitare il numero o parte numerodel contatto:");
                        parametro = input.next();
                        int indiceContatto;
                        boolean sure = false;
                        while (!sure) {
                            System.out.println("Scegli il contatto da eliminare digitando il suo indice...");
                            for (Contatto i : rubrica) {
                                if (i.getTelefono().contains(parametro)) {
                                    System.out.println(i + "\nCon indice: " + rubrica.indexOf(i));
                                    System.out.println(" ");
                                }
                            }
                            indiceContatto = input.nextInt();
                            System.out.println("Procedere all'eliminazione? Inserire: true/false");
                            sure = input.nextBoolean();
                            if (sure) {
                                System.out.println("Contatto: " + rubrica.get(indiceContatto) + " rimosso consuccesso!");
                                rubrica.remove(indiceContatto);
                            } else {
                                System.out.println("Vuoi annullare l'operazione elimina contatto? Inserire: true/false");
                                sure = input.nextBoolean();
                            }
                        }
                    }
                    break;
                case 0:
                    running = false;
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Errore input non valido!\n Inserisci un input valido");
                    input.nextInt();
            }
        }

    }
}

/**
 * Contatto della rubrica
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
