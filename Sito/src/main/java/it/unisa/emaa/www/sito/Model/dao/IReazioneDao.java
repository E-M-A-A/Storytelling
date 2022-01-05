package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.ReazioneId;

import java.util.List;

public interface IReazioneDao {
    public List<ReazioneId> doRetrieve(int idStoria, String email);
    public List<ReazioneId> doRetrieveByStoria(int idStoria);
    public List<ReazioneId> doRetrieveByEmail(String email);
    public ReazioneId doSave(ReazioneId reazione);


}

