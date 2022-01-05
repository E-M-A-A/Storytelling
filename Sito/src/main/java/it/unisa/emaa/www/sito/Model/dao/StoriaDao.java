package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Storia;

import java.util.Date;
import java.util.List;

public class StoriaDao implements IStoriaDao {
    @Override
    public List<Storia> doRetrieveAll() {
        return null;
    }

    @Override
    public Storia doRetrieveById(int id) {
        return null;
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
