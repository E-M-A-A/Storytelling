package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Commento;

import java.util.List;

public interface ICommentoDao {
    public List<Commento> doRetrieveByAll();
    public Commento doRetrieveByStoria(int idStoria);
    public boolean doSave(Commento commento);




}
