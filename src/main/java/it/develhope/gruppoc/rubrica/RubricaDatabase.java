package it.develhope.gruppoc.rubrica;

import it.develhope.gruppoc.Classi.Contatto;
import it.develhope.gruppoc.Exeptions.ReadContactsExeption;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RubricaDatabase extends Rubrica {

    private Connection conn = null;

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/rubrica?" + "user=root&password=root";

    public RubricaDatabase() throws Exception {
        super();
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    }

    @Override
    public void salvaContatto() {

    }

    @Override
    protected void init() throws Exception {
        createConnection();
        List<Contatto> contatti = leggiContattiDaDB();
        if (contatti == null) {
            throw new ReadContactsExeption("DATABASE");
        }
        rubricaContatti.addAll(contatti);
    }

    private List<Contatto> leggiContattiDaDB() {
        Statement stmt = null;
        ResultSet rs = null;

        List<Contatto> res = null;

        try {
            res = new ArrayList<>();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Contatto");

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            if (stmt.execute("SELECT * FROM Contatto")) {
                rs = stmt.getResultSet();
            }


            while (rs.next()) {
                Contatto c = new Contatto();
                c.setId(BigInteger.valueOf(rs.getBigDecimal("id").longValue()));
                c.setNome(rs.getString("nome"));
                c.setCognome(rs.getString("cognome"));
                c.setTelefono(rs.getString("numero_telefono"));
                c.setEmail(rs.getString("email"));
                res.add(c);
            }

            // Now do something with the ResultSet ....
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {

                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {

                } // ignore

                stmt = null;
            }
        }
        return res;
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
