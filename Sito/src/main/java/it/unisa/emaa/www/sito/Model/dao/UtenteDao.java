package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class UtenteDao implements IUtenteDao{
    @Override
    public List<Utente> doRetrieveAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em= emf.createEntityManager();
        ArrayList<Utente> list= (ArrayList<Utente>) em.createNamedQuery("retrieveAll",Utente.class).getResultList();
        return list;
    }

    @Override
    public Utente doRetrieveByUsername(String username) {
        return null;
    }

    @Override
    public Utente doRetrieveByEmail(String email) {
        return null;
    }
}
