package it.unisa.emaa.www.sito.Model.dao;

import it.unisa.emaa.www.sito.Model.entity.Storia;
import java.util.Date;
import java.util.List;

/**
 * Interfaccia IStoriaDao contenente i metodi da far eseguire alla rispettiva classe StoriaDao
 *
 *
 *
 * @author Antonio Scotellaro
 */



public interface IStoriaDao {
    Storia doRetrieveById(int id);
    boolean doSave(Storia storia);
    List<Storia> doRetrieveByPage(int limit, int offset);





}
