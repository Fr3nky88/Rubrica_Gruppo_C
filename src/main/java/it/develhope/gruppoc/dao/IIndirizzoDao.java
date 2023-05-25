package it.develhope.gruppoc.dao;

import it.develhope.gruppoc.Classi.Indirizzo;

import java.util.List;

public interface IIndirizzoDao {

    public List<Indirizzo> getAllIndirizzo();

    public Indirizzo getIndirizzo(Integer id);

    public void salvaIndirizzo(Indirizzo i);

    public void deleteIndirizzo(Integer i);
}
