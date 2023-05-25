package it.develhope.gruppoc.rubrica;

import it.develhope.gruppoc.Classi.Contatto;
import it.develhope.gruppoc.Exeptions.ReadContactsExeption;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RubricaDatabase extends Rubrica {
    
    private static final String CONNECTION_STRING_URL = "jdbc:mysql://localhost:3306/rubrica";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    public RubricaDatabase() throws Exception {
        super();
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    }

    @Override
    public void salvaContatto(Contatto c) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(CONNECTION_STRING_URL, USER, PASSWORD);
            stmt = conn.createStatement();

            String sql = "INSERT INTO Contatto " +
                    "(nome, cognome, numero_telefono, email)" +
                    "VALUES(?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, c.getNome());
            preparedStatement.setString(2, c.getCognome());
            preparedStatement.setString(3, c.getTelefono());
            preparedStatement.setString(4, c.getEmail());

            int numRigheAggiornate = preparedStatement.executeUpdate();


            // Now do something with the ResultSet ....
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {

                } // ignore

                stmt = null;
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlEx) {

                } // ignore

                conn = null;
            }
        }
    }

    @Override
    protected void init() throws Exception {
        List<Contatto> contatti = leggiContattiDaDB();
        if (contatti == null) {
            throw new ReadContactsExeption("DATABASE");
        }
        rubricaContatti.addAll(contatti);
    }

    private List<Contatto> leggiContattiDaDB() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        List<Contatto> res = null;

        try {
            res = new ArrayList<>();
            conn = DriverManager.getConnection(CONNECTION_STRING_URL, USER, PASSWORD);
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

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlEx) {

                } // ignore

                conn = null;
            }
        }
        return res;
    }

}
