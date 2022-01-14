package Model;

import it.unisa.emaa.www.sito.Model.ConnPool;
import it.unisa.emaa.www.sito.Model.dao.StoriaDao;
import it.unisa.emaa.www.sito.Model.entity.Storia;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StoriaDaoTest {
    private static Storia storia;
    private StoriaDao dao = new StoriaDao();
    Connection connection;
    private String utentequery1 = "INSERT INTO utente VALUES('e.coppola37@studenti.unisa.it','Casdwa324$','emmavico')";
    private String utentequery2 = "INSERT INTO utente VALUES('pippo@gmail.com','GIAcc7£','giaccarello')";

    private String storiaquery1 = "INSERT INTO storia VALUES('emmavico','Questa è una bella storia',0,0,'"+ LocalDate.now()+"')";
    private String storiaquery2 = "INSERT INTO storia VALUES('emmavico','Una altra storia',0,0,'"+LocalDate.now()+"')";
    private String storiaquery3 = "INSERT INTO storia VALUES('giaccarello','Una storia a parte',0,0,'"+LocalDate.now()+"')";
    @Test
    public void doRetrieveAllTest() throws SQLException {
        List<Storia> storie = new ArrayList<>();
        List<Storia> storieDB;
        Storia storia1 = new Storia();
        Storia storia2 = new Storia();
        Storia storia3 = new Storia();
        storia1.setId(1);
        storia1.setUsername("emmavico");
        storia1.setContenuto("Questa è una bella storia");
        storia1.setNCommenti(0);
        storia1.setNReazioni(0);
        storia1.setDataCreazione(LocalDate.now());
        storia2.setId(2);
        storia2.setUsername("emmavico");
        storia2.setContenuto("Una altra storia");
        storia2.setNCommenti(0);
        storia2.setNReazioni(0);
        storia2.setDataCreazione(LocalDate.now());
        storia3.setId(3);
        storia3.setUsername("giaccarello");
        storia3.setContenuto("Una storia a parte");
        storia3.setNCommenti(0);
        storia3.setNReazioni(0);
        storia3.setDataCreazione(LocalDate.now());
        storie.add(storia1);
        storie.add(storia2);
        storie.add(storia3);
        connection = ConnPool.getConnection();

            Statement statement = connection.createStatement();
            statement.executeUpdate(utentequery1);
            statement.executeUpdate(utentequery2);
            statement.executeUpdate(storiaquery1);
            statement.executeUpdate(storiaquery2);
            statement.executeUpdate(storiaquery3);
            storieDB = dao.doRetrieveAll();
            boolean test1 = true;
            boolean test2 = true;
            for(Storia s: storie)
            {
                test1 = false;
                for(Storia sDB: storieDB)
                {
                    if(s.equals(sDB))
                    {
                        test1 = true;
                    }
                }
                if(!test1)
                {
                    test2 = false;
                }
            }

            assertTrue("La lista di utenti non è restituita correttamente", test2);
            try {
                connection = ConnPool.getConnection();
                statement = connection.createStatement();
                statement.executeUpdate("DELETE FROM utente WHERE email = 'pippo@gmail.com'");
                statement.executeUpdate("DELETE FROM utente WHERE email = 'e.coppola37@studenti.unisa.it'");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
