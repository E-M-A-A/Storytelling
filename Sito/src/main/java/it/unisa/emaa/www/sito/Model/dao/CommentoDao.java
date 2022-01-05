package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Commento;
import it.unisa.emaa.www.sito.Model.entity.Storia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CommentoDao implements ICommentoDao{
    @Override
    public List<Commento> doRetrieveByAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        ArrayList<Commento> list = (ArrayList<Commento>) em.createNamedQuery("retrieveAll", Commento.class).getResultList();
        return list;
    }

    @Override
    public Commento doRetrieveByStoria(int idStoria) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("retrieveByStoria",Commento.class);
        query.setParameter("fid",idStoria);
        Commento commento = (Commento) query.getSingleResult();
        return commento;
    }

    @Override
    public boolean doSave(Commento commento) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        em.persist(commento);
        return true;

    }


}
