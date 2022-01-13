package Model;

import it.unisa.emaa.www.sito.Model.ConnPool;
import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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
    private static Connection connection;
    private String data1 = "INSERT INTO Utente VALUES('e.coppola37@studenti.unisa.it','Casdwa324$','emmavico'";
    private String data2 = "INSERT INTO Utente VALUES('pippo@gmail.com','GIAcc7£','giaccarello'";


    @BeforeAll
    static void setup() throws SQLException {
        connection = ConnPool.getConnection();

        utente = new Utente();
        utente.setId("e.coppola37@studenti.unisa.it");
        utente.setPassword("Casdwa324$");
        utente.setUsername("emmavico");
    }

    @BeforeEach
    public void generazioneTupleTest() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(data1);
            statement.executeUpdate(data2);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @AfterEach
    public void rimozioneDatiTest() {
        try {
            Statement statement = connection.createStatement();
            String qry1 = "DELETE * FROM Utente Where email = 'pippo@gmail.com'";
            String qry2 = "DELETE * FROM Utente Where email = 'e.coppola37@studenti.unisa.it'";
            statement.executeUpdate(qry1);
            statement.executeUpdate(qry2);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteTest() {
        dao.doDelete("pippo@gmail.com");
        try {
            Statement statement = connection.createStatement();
            String qry = "Select * FROM Utente Where email = 'pippo@gmail.com'";
            ResultSet rs = statement.executeQuery(qry);
            assertTrue("Oggetto ancora presente nonostante la cancellazione", !rs.isBeforeFirst());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void RetrieveByUsernameTest() {
        assertTrue("Ritornato un'oggetto Errato per email", dao.doRetrieveByEmail("emmavico").equals(utente));
    }

    @Test
    public void RetrieveByEmailTest() {
        assertTrue(dao.doRetrieveByEmail("emmavico").equals(utente));
    }
}

