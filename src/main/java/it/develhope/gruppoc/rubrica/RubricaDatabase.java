package it.develhope.gruppoc.rubrica;

import it.develhope.gruppoc.Classi.Contatto;
import it.develhope.gruppoc.Exeptions.ReadContactsExeption;
import it.develhope.gruppoc.dao.ContattoDao;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RubricaDatabase extends Rubrica {
    
    private static final String CONNECTION_STRING_URL = "jdbc:mysql://raspberrypi:3306/rubrica";
    private static final String USER = "root";
    private static final String PASSWORD = "Fr3nky88?";

    private Connection conn = null;

    private ContattoDao contattoDao;

    public RubricaDatabase() throws Exception {
        super();
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(CONNECTION_STRING_URL, USER, PASSWORD);
        this.contattoDao = new ContattoDao(conn);
    }

    @Override
    public void salvaContatto(Contatto c) {
        contattoDao.salvaContatto(c);
    }

    @Override
    protected void init() throws Exception {
        List<Contatto> contatti = leggiContattiDaDB();
        if (contatti == null) {
            throw new ReadContactsExeption("DATABASE");
        }
        rubricaContatti.addAll(contatti);
    }

    @Override
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException sqlEx) {

            } // ignore

            conn = null;
        }
    }

    private List<Contatto> leggiContattiDaDB() {
        return contattoDao.getAllContatto();
    }

}
