package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Storia;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    }

    @Override
    public boolean doDelete(Storia storia) {
        return false;
    }

    @Override
    public Storia doSave(Storia storia) {
        return null;
    }

    @Override
    public List<Storia> doRetrieveByDate(Date date) {
        return null;
    }

    @Override
    public List<Storia> doRetrieveByPage(int limit, int offset) {
        return null;
    }
}
