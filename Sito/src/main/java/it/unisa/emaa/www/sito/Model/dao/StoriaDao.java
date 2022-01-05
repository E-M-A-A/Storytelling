package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Storia;

import javax.persistence.*;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoriaDao implements IStoriaDao {
    @Override
    public List<Storia> doRetrieveAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        ArrayList<Storia> list = (ArrayList<Storia>) em.createNamedQuery("retrieveAll", Storia.class).getResultList();
        return list;
    }

    @Override
    public Storia doRetrieveById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("retrieveById",Storia.class);
        query.setParameter("fid",id);
        Storia storia = (Storia) query.getSingleResult();
        return storia;

    }

    @Override
    public boolean doDelete(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        em.remove(id);
        return true; //storia rimossa
    }

    @Override
    public boolean doSave(Storia storia) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        em.persist(storia);
        return true;  //storia salvata

    }

    @Override
    public List<Storia> doRetrieveByDate(Date date) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("retrieveByDate",Storia.class);
        query.setParameter("fdate",date);
        ArrayList<Storia> list = (ArrayList<Storia>) query.getResultList();
        return list;

    }

    @Override
    public List<Storia> doRetrieveByPage(int limit, int offset) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("retrieveByPage",Storia.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        ArrayList<Storia> list = (ArrayList<Storia>) query.getResultList();
        return list;

    }
}
