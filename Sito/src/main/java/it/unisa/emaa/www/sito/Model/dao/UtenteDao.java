package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("retrieveByUsername", Utente.class); // è un oggetto query
        query.setParameter("fusername",username);
        Utente utente = (Utente) query.getSingleResult();
        return utente;
    }

    @Override
    public Utente doRetrieveByEmail(String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        Query query =  em.createNamedQuery("retrieveByEmail", Utente.class);
        query.setParameter("femail",email);
        Utente utente = (Utente) query.getSingleResult();
        return utente;

    }

    @Override
    public boolean doSave(Utente utente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        em.persist(utente);
        return true; // da gestire anche il caso di return false
    }

    @Override
    public boolean doDelete(String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        em.remove(email);
        return true; // da gestire anche il caso di return false
    }
}
