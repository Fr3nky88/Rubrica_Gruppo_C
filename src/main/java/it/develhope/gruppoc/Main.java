package it.develhope.gruppoc;

import it.develhope.gruppoc.rubrica.Rubrica;
import it.develhope.gruppoc.rubrica.RubricaFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Rubrica rubrica = new RubricaFile();
            rubrica.start();
        } catch (IOException e) {
            System.out.println("Non e possibile memorizzare la rubrica su PC");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Errore generico, fai schifo :)");
            e.printStackTrace();
            System.exit(0);
        }
    }
}