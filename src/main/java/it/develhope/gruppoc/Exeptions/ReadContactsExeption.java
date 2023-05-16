package it.develhope.gruppoc.Exeptions;

public class ReadContactsExeption extends Exception {
    public ReadContactsExeption(String from) {
        super("Errore nella lettura dei contatti da " + from);
    }
}
