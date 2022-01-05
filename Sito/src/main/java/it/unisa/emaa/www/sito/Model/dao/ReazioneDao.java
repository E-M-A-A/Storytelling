package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Reazione;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ReazioneDao implements IReazioneDao{

    @Override
    public List<Reazione> doRetrieveByStoria(int idStoria) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("retrieveByIdStoria", Reazione.class);
        query.setParameter("fidStoria",idStoria);
        ArrayList<Reazione> list = (ArrayList<Reazione>) query.getResultList();
        return list;

    }

    @Override
    public List<Reazione> doRetrieveByEmail(String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("retrieveByEmail", Reazione.class);
        query.setParameter("femail",email);
        ArrayList<Reazione> list = (ArrayList<Reazione>) query.getResultList();
        return list;
    }

    @Override
    public boolean  doSave(Reazione reazione) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        em.persist(reazione);
        return true;  // da gestire anche il caso di return false
    }
}
