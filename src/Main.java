import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Rubrica rubrica = new Rubrica();
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