package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Reazione;

import java.util.List;

public interface IReazioneDao {
    public List<Reazione> doRetrieveByStoria(int idStoria);
    public List<Reazione> doRetrieveByEmail(String email);



}
