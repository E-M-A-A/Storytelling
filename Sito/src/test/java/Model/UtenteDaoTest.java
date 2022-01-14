package Model;

import it.unisa.emaa.www.sito.Model.ConnPool;
import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;
/*
/**La classe si occupa di testare la classe UtenteDao nei metodi di communicazione con il database
 * @author Emmanuele Virginio Coppola
 *
 * Questa classe di test � stata scritta secondo la
 * metodologia WHITE BOX.
 */

public class UtenteDaoTest {
    private static Utente utente;
    private UtenteDao dao = new UtenteDao();

    private String data1 = "INSERT INTO utente VALUES('e.coppola37@studenti.unisa.it','Casdwa324$','emmavico')";
    private String data2 = "INSERT INTO utente VALUES('pippo@gmail.com','GIAcc7£','giaccarello')";


    private void setup() {


        utente = new Utente();
        utente.setId("e.coppola37@studenti.unisa.it");
        utente.setPassword("Casdwa324$");
        utente.setUsername("emmavico");
    }

    private void generazioneTupleTest() {
        Connection connection;

    }


    void rimozioneDatiTest() {
        Connection connection;
        try {
            connection  = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            String qry1 = "DELETE FROM utente Where email = 'pippo@gmail.com'";
            String qry2 = "DELETE FROM utente Where email = 'e.coppola37@studenti.unisa.it'";
            statement.executeUpdate(qry1);
            statement.executeUpdate(qry2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.rimozioneDatiTest();
    }

    @Test
    public void deleteTest() {
        Connection connection;
        try {
            connection  = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(data1);
            statement.executeUpdate(data2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dao.doDelete("pippo@gmail.com");
        try {
            connection  = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            String qry = "Select * FROM utente Where email = 'pippo@gmail.com'";
            ResultSet rs = statement.executeQuery(qry);
            assertTrue("Oggetto ancora presente nonostante la cancellazione", !rs.isBeforeFirst());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void RetrieveByUsernameTest() {
        this.generazioneTupleTest();
        Connection connection;
        try {
            connection  = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(data1);
            statement.executeUpdate(data2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue("Ritornato un'oggetto Errato per email", dao.doRetrieveByUsername("emmavico").equals(utente));
        this.rimozioneDatiTest();
    }

    @Test
    public void RetrieveByEmailTest() {
        this.generazioneTupleTest();
        assertTrue(dao.doRetrieveByEmail("e.coppola37@studenti.unisa.it").equals(utente));
        this.rimozioneDatiTest();
    }
}