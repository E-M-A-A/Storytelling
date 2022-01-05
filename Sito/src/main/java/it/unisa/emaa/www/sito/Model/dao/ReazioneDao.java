package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.ReazioneId;

import java.util.List;

public class ReazioneDao implements IReazioneDao{
    @Override
    public List<ReazioneId> doRetrieve(int idStoria, String email) {
        return null;

    }

    @Override
    public List<ReazioneId> doRetrieveByStoria(int idStoria) {
        return null;
    }

    @Override
    public List<ReazioneId> doRetrieveByEmail(String email) {
        return null;
    }

    @Override
    public ReazioneId doSave(ReazioneId reazione) {

        return null;
    }
}
