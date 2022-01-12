package it.unisa.emaa.www.sito.Model.dao;
import it.unisa.emaa.www.sito.Model.entity.Storia;
import java.util.Date;
import java.util.List;

public interface IStoriaDao {
    public List<Storia> doRetrieveAll();
    public Storia doRetrieveById(int id);
    public boolean doDelete(int id);
    public boolean doSave(Storia storia);
  //  public List<Storia> doRetrieveByDate(Date date);
    public List<Storia> doRetrieveByPage(int limit, int offset);
    // da vedere reazioni





}
