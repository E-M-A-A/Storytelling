package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Commento;

import java.sql.SQLException;
import java.util.List;

public interface ICommentoDao {
    public List<Commento> doRetrieveByAll() throws SQLException;
    public List<Commento> doRetrieveByStoria(int idStoria);
    public boolean doSave(Commento commento);




}
