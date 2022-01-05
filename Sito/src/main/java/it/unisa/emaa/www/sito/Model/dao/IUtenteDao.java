package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Utente;

import java.util.List;

public interface IUtenteDao {
    public List<Utente> doRetrieveAll();
    public Utente doRetrieveByUsername(String username);
    public Utente doRetrieveByEmail(String email);
    public boolean doSave(Utente utente);
    public boolean doDelete(String email);



}

