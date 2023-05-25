package it.develhope.gruppoc.rubrica;

import it.develhope.gruppoc.Classi.Contatto;
import it.develhope.gruppoc.Exeptions.ReadContactsExeption;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RubricaFile extends Rubrica {
    private static final Path FILE_PATH = Path.of(System.getProperty("user.home"), "Rubrica", "Rubrica.csv");

    public RubricaFile() throws Exception {
        super();
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

    @Override
    public void salvaContatto(Contatto c) {
        try {
            FileWriter rubricaFile = new FileWriter(FILE_PATH.toFile());
                rubricaFile.append(c.getNome()).append(",").append(c.getCognome()).append(",").append(c.getTelefono()).append("\n");
            rubricaFile.close();
        } catch (IOException e) {
            System.out.println("Errore");
        }
    }

    @Override
    protected void init() throws Exception {
        try {
            creaFile();
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
                Contatto contatto = new Contatto(arrayLinea[0], arrayLinea[1], arrayLinea[2], null);
                rubricaContatti.add(contatto);
            }
        } catch (Exception e) {
            throw new ReadContactsExeption("FILE");
        }
    }

    @Override
    public void close() {

    }
}
