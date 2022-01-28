package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Commento;
import java.sql.SQLException;
import java.util.List;

/**
 * Interfaccia ICommentoDao contenente i metodi da far eseguire alla rispettiva classe CommentoDao
 *
 *
 *
 * @author Antonio Scotellaro
*/


public interface ICommentoDao {
    public List<Commento> doRetrieveAll() throws SQLException;
    public List<Commento> doRetrieveByStoria(int idStoria) throws SQLException;
    public boolean doSave(Commento commento) throws SQLException;




}
