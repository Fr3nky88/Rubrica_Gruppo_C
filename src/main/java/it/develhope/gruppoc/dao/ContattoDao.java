package it.develhope.gruppoc.dao;

import it.develhope.gruppoc.Classi.Contatto;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContattoDao implements IContattoDao{

    private Connection conn;

    public ContattoDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Contatto> getAllContatto() {
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

    @Override
    public Contatto getContatto(Integer id) {
        return null;
    }

    @Override
    public void salvaContatto(Contatto c) {
        Statement stmt = null;
        Connection conn = null;

        try {
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
        }
    }

    @Override
    public void deleteContatto(Integer id) {

    }
}
