import Classi.Contatto;
import Classi.ContattoConIndirizzo;
import Classi.Indirizzo;
import Classi.SortedList;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Rubrica {
    private Scanner input;
    private List<ContattoConIndirizzo> rubrica;
    private SortedList<Contatto> rubricaContatti;
    private List<Indirizzo> rubricaIndirizzi;
    private static final Path FILE_PATH = Path.of(System.getProperty("user.home"), "Rubrica", "Rubrica.csv");


    public Rubrica() throws IOException {
        input = new Scanner(System.in);
        rubrica = new ArrayList<>();
        rubricaIndirizzi = new ArrayList<>();
        creaFile();
        Comparator<Contatto> comparator = new Comparator<Contatto>() {
            @Override
            public int compare(Contatto o1, Contatto o2) {
                if (o1.getCognome().equals(o2.getCognome())) {
                    return 0;
                }
                if (o1.getCognome() == null) {
                    return -1;
                }
                if (o2.getCognome() == null) {
                    return 1;
                }
                return o1.getCognome().compareTo(o2.getCognome());
            }
        };
        rubricaContatti = new SortedList<>(comparator);
        leggiFile();
    }

    public void start() {
        boolean running = true;
        while (running) {

            visualizzaMenu();
            int scelta = input.nextInt();

            switch (scelta) {
                case 1 -> aggiungiContatto();
                case 2 -> cercaContatto();
                case 3 -> visualizzaContatti();
                case 4 -> cancellaContatto();
                case 5 -> aggiungiIndirizzo();
//                case 6 -> cercaIndirizzo();
//                case 7 -> visualizzaIndirizzi();
//                case 8 -> cancellaIndirizzo();
//                case 9 -> unisciContattoConIndirizzo;
                case 0 -> running = spegnimento();
                default -> {
                    System.out.println("Errore input non valido!\n Inserisci un input valido");
                    input.nextInt();
                }
            }
        }
    }
    private void creaFile() throws IOException {
        String userHome = System.getProperty("user.home");
        Path rubricaFolder = Path.of(userHome, "Rubrica");
        try {
            Files.createDirectory(rubricaFolder);
        } catch (FileAlreadyExistsException e) {
            System.out.println("Directory already exist");
        }
        try {
            Files.createFile(FILE_PATH);
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exist");
        }
    }
    private void leggiFile() throws IOException {
//        Contatto contatto = new Contatto();
////        FileReader rubricaFile = new FileReader(FILE_PATH.toFile());
//        StringBuilder stringa = new StringBuilder();
//        int data = rubricaFile.read();
//        while (data != -1) {
//            if (!((char) data == ' ')) {
//                stringa.append((char) data);
//            }else {
//
//            }
//            data = rubricaFile.read();
//        }
        List<String> listaRubrica = Files.readAllLines(FILE_PATH);
        for(String linea : listaRubrica) {
            String[] arrayLinea = linea.split(",");
            Contatto contatto = new Contatto(arrayLinea[0], arrayLinea[1], arrayLinea[2]);
            rubricaContatti.add(contatto);
        }
}
    private void visualizzaMenu() {
        System.out.println("Seleziona un'operazione:");
        System.out.println("1. Aggiungi contatto");
        System.out.println("2. Cerca contatto");
        System.out.println("3. Visualizza tutti i contatti");
        System.out.println("4. Cancella contatto");
        System.out.println("5. Aggiungi indirizzo");
        System.out.println("0. Esci");
    }

    private void aggiungiContatto() {
        System.out.println("\n Aggiungi il tuo contatto!");
        System.out.println("\n Digita il nome!");
        String nome = input.next();

        System.out.println("\n Digita il cognome!");
        String cognome = input.next();

        System.out.println("\n Digita ora il numero!");
        String numero= input.next();

        Contatto contatto = new Contatto(nome, cognome, numero);

        rubricaContatti.add(contatto);

        try {
        FileWriter rubricaFile = new FileWriter(FILE_PATH.toFile());
            for (Contatto index : rubricaContatti) {
                rubricaFile.append(index.getNome()).append(",").append(index.getCognome()).append(",").append(index.getTelefono()).append("\n");
            }
            rubricaFile.close();
        } catch (IOException e) {
            System.out.println("Errore");
        }

        System.out.println("Contatto aggiunto con successo!");
    }

    private void cercaContatto() {
        System.out.println("Vuoi cercare per: nome, cognome o numero?");
        String parametro = input.next();
        if ("nome".contains(parametro.toLowerCase())){
            System.out.println("Digitare il nome del contatto:");
            parametro = input.next();
            for (Contatto i : rubricaContatti) {
                if (parametro.equalsIgnoreCase(i.getNome().toLowerCase())) {
                    System.out.println(i);
                }
            }
        } else if ("cognome".contains(parametro.toLowerCase())){
            System.out.println("Digitare il cognome del contatto:");
            parametro = input.next();
            for (Contatto i : rubricaContatti) {
                if (parametro.equalsIgnoreCase(i.getCognome().toLowerCase())) {
                    System.out.println(i);
                }
            }
        } else if ("numero".contains(parametro.toLowerCase())){
            System.out.println("Digitare il numero o parte numero del contatto:");
            parametro = input.next();
            for (Contatto i : rubricaContatti) {
                if (i.getTelefono().contains(parametro)) {
                    System.out.println(i);
                }
            }
        }
    }

    private void visualizzaContatti() {
        for (Contatto contatto : rubricaContatti) {
            System.out.println(contatto);
        }
    }

    private void cancellaContatto() {
        System.out.println("Ricerca del contatto da eliminare...");
        System.out.println("Vuoi cercare per: nome, cognome o numero?");
        String parametro = input.next();
        if ("nome".contains(parametro.toLowerCase())){
            System.out.println("Digitare il nome del contatto:");
            parametro = input.next();
            int indiceContatto;
            boolean sure = false;
            while (!sure) {
                System.out.println("Scegli il contatto da eliminare digitando il suo indice...");
                for (Contatto i : rubricaContatti) {
                    if (parametro.equalsIgnoreCase(i.getNome().toLowerCase())) {
                        System.out.println(i + "\nCon indice: " + rubricaContatti.indexOf(i));
                        System.out.println(" ");
                    }
                }
                indiceContatto = input.nextInt();
                System.out.println("Procedere all'eliminazione? Inserire: true/false");
                sure = input.nextBoolean();
                if (sure) {
                    System.out.println("Contatto: " + rubricaContatti.get(indiceContatto) + " rimosso con successo!");
                    rubricaContatti.remove(indiceContatto);
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
                for (Contatto i : rubricaContatti) {
                    if (parametro.equalsIgnoreCase(i.getCognome().toLowerCase())) {
                        System.out.println(i + "\nCon indice: " + rubricaContatti.indexOf(i));
                        System.out.println(" ");
                    }
                }
                indiceContatto = input.nextInt();
                System.out.println("Procedere all'eliminazione? Inserire: true/false");
                sure = input.nextBoolean();
                if (sure) {
                    System.out.println("Contatto: " + rubricaContatti.get(indiceContatto) + " rimosso con successo!");
                    rubricaContatti.remove(indiceContatto);
                } else {
                    System.out.println("Vuoi annullare l'operazione elimina contatto? Inserire: true/false");
                    sure = input.nextBoolean();
                }
            }
        } else if ("numero".contains(parametro.toLowerCase())){
            System.out.println("Digitare il numero o parte numero del contatto:");
            parametro = input.next();
            int indiceContatto;
            boolean sure = false;
            while (!sure) {
                System.out.println("Scegli il contatto da eliminare digitando il suo indice...");
                for (Contatto i : rubricaContatti) {
                    if (i.getTelefono().contains(parametro)) {
                        System.out.println(i + "\nCon indice: " + rubricaContatti.indexOf(i));
                        System.out.println(" ");
                    }
                }
                indiceContatto = input.nextInt();
                System.out.println("Procedere all'eliminazione? Inserire: true/false");
                sure = input.nextBoolean();
                if (sure) {
                    System.out.println("Contatto: " + rubricaContatti.get(indiceContatto) + " rimosso con successo!");
                    rubricaContatti.remove(indiceContatto);
                } else {
                    System.out.println("Vuoi annullare l'operazione elimina contatto? Inserire: true/false");
                    sure = input.nextBoolean();
                }
            }
        }
    }

    private Boolean spegnimento() {
        System.out.println("Arrivederci!");
        return false;
    }

    private void aggiungiIndirizzo() {
        System.out.println("\n Aggiungi il tuo indirizzo!");
        System.out.println("\n Digita la via!");
        String via = input.next();

        System.out.println("\n Digita il numero civico!");
        String numCivico = input.next();

        System.out.println("\n Digita ora il cap!");
        String cap = input.next();

        System.out.println("\n Digita la località!");
        String locality = input.next();

        System.out.println("\n Digita la provincia!");
        String provincia = input.next();

        System.out.println("\n Digita indicazioni aggiuntive se necessario!");
        String indicazioniAgg= input.next();

        Indirizzo indirizzo = new Indirizzo(via, numCivico, cap, locality, provincia, indicazioniAgg);

        rubricaIndirizzi.add(indirizzo);

        System.out.println("Indirizzo aggiunto con successo!");
    }
    private void leggiRubricaDaFile() {

    }
}
