package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Reazione;
import java.util.List;


/**
 * Interfaccia IReazioneDao contenente i metodi da far eseguire alla rispettiva classe ReazioneDao
 *
 *
 *
 * @author Antonio Scotellaro
 */


public interface IReazioneDao {

    public List<Reazione> doRetrieveByStoria(int idStoria);
    public List<Reazione> doRetrieveByEmail(String email);
    public Reazione doRetrieve(String email,int idStoria);
    public boolean doSave(Reazione reazione);


}

