package Model;

import it.unisa.emaa.www.sito.Model.ConnPool;
import it.unisa.emaa.www.sito.Model.dao.ReazioneDao;
import it.unisa.emaa.www.sito.Model.dao.StoriaDao;
import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Reazione;
import it.unisa.emaa.www.sito.Model.entity.Storia;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/*
/**La classe si occupa di testare la classe UtenteDao nei metodi di communicazione con il database
 * @author Emmanuele Virginio Coppola
 *
 * Questa classe di test � stata scritta secondo la
 * metodologia WHITE BOX.
 */

public class ReazioneDaoTest {
    private static Utente utente;
    private ReazioneDao dao = new ReazioneDao();
    private static Storia storia;
    private static Reazione reazione;
    Connection connection;


    private String data1 = "INSERT INTO utente VALUES('e.coppola37@studenti.unisa.it','Casdwa324$','emmavico')";
    private String data2 = "INSERT INTO utente VALUES('pippo@gmail.com','GIAcc7£','giaccarello')";


    private String storiaquery1 = "INSERT INTO storia VALUES(1, 'emmavico','Questa è una bella storia',0,0,'"+ LocalDate.now()+"')";
    private String storiaquery2 = "INSERT INTO storia VALUES(2, 'emmavico','Una altra storia',0,0,'"+LocalDate.now()+"')";
    private String storiaquery3 = "INSERT INTO storia VALUES(3, 'giaccarello','Una storia a parte',0,0,'"+LocalDate.now()+"')";

    /*
    private String idStoria1 = "SELECT idStoria FROM storia WHERE email = 'pippo@gmail.com'";
    private int id1 = Integer.parseInt(idStoria1);
    private String idStoria2 = "SELECT idStoria FROM storia WHERE email = 'e.coppola37@studenti.unisa.it'";
    private int id2 = Integer.parseInt(idStoria2);
    */

    private String reazionequery1 = "INSERT INTO reazione VALUES('1','e.coppola37@studenti.unisa.it')";
    private String reazionequery2 = "INSERT INTO reazione VALUES('2','pippo@gmail.com')";

    String qry = "Select * FROM utente Where email = 'pippo@gmail.com'";

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
            connection = ConnPool.getConnection();
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
/*
    @Test
    public void deleteTest() {
        Connection connection;
        try {
            connection = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(data1);
            statement.executeUpdate(data2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dao.doDelete("pippo@gmail.com");
        try {
            connection = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            String qry = "Select * FROM utente Where email = 'pippo@gmail.com'";
            ResultSet rs = statement.executeQuery(qry);
            assertTrue("Oggetto ancora presente nonostante la cancellazione", !rs.isBeforeFirst());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   */
    @Test 
    void doRetrieveByStoriaTest() {
        Connection connection;
        List<Reazione> oracolo = new ArrayList<>();
        List<Reazione> test;
        Utente utente = new Utente();

        Storia storia1 = new Storia();

        Reazione reazione1 = new Reazione();
        Reazione reazione2 = new Reazione();

        utente.setUsername("emmavico");
        utente.setId("e.coppola37@studenti.unisa.it");
        utente.setPassword("Casdwa324$");

        storia1.setId(1);
        storia1.setUsername("emmavico");
        storia1.setContenuto("Questa è una bella storia");
        storia1.setNCommenti(0);
        storia1.setNReazioni(0);
        storia1.setDataCreazione(LocalDate.now());

        reazione1.setIdStoria(1);
        reazione1.setEmailUtente("e.coppola37@studenti.unisa.it");
        reazione2.setEmailUtente("pippo@gmail.com");
        reazione2.setIdStoria(1);

        oracolo.add(reazione1);
        oracolo.add(reazione2);


        test = dao.doRetrieveByStoria(1);
        boolean test1 = true;
        boolean test2 = true;
        for(Reazione x: oracolo)
        {
            test1 = false;
            for(Reazione y: test)
            {
                if(x.equals(y))
                {
                    test1 = true;
                }
            }
            if(test1 == false)
            {
                test2 = false;
            }
        }

        assertTrue("La lista di reazioni non è restituita correttamente", test2);

        try {
            connection = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM utente WHERE email = 'pippo@gmail.com'");
            statement.executeUpdate("DELETE FROM utente WHERE email = 'e.coppola37@studenti.unisa.it'");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    /*
        try {
            connection = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(data1);
            statement.executeUpdate(data2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    */
    }



        @Test
    public void RetrieveByEmailTest() {
        Connection connection;
        Utente utente1, utente2;
        utente2 = new Utente();
        utente2.setPassword("GIAcc7£");
        utente2.setId("pippo@gmail.com");
        utente2.setUsername("giaccarello");


        try {
            connection = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(data2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        utente = dao.doRetrieveByEmail("pippo@gmail.com");
        assertTrue("Ritornato un utente Errato per email", utente.equals(utente2));

        try {
            connection = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM utente WHERE email = 'pippo@gmail.com'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void RetrieveByUsernameTest() {
        Connection connection;
        Utente utente1, utente2;
        utente2 = new Utente();
        utente2.setPassword("GIAcc7£");
        utente2.setId("pippo@gmail.com");
        utente2.setUsername("giaccarello");


        try {
            connection = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(data2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        utente = dao.doRetrieveByUsername("giaccarello");
        assertTrue("Ritornato un utente Errato per username", utente.equals(utente2));

        try {
            connection = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM utente WHERE email = 'pippo@gmail.com'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doSaveTest() {

        Connection connection;
        Utente utente1, utente2;
        utente2 = new Utente();
        utente2.setPassword("GIAcc7£");
        utente2.setId("pippo@gmail.com");
        utente2.setUsername("giaccarello");
        String username;
        String email;
        String password;
        Utente utente = new Utente();


        dao.doSave(utente2);
        try {
            connection = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            //username = statement.executeQuery("SELECT username FROM utente WHERE email = 'pippo@gmail.com'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection = ConnPool.getConnection();
            PreparedStatement ps = connection.prepareStatement("Select * from utente  where email =?");
            ps.setString(1, "pippo@gmail.com");
            ResultSet rs = ps.executeQuery();
            boolean flag = true;
            if (!rs.isBeforeFirst())
                flag = false;
            else {
                rs.next();
                utente.setId(rs.getString("email"));
                utente.setUsername(rs.getString("username"));
                utente.setPassword(rs.getString("password"));
                rs.close();
            }

            assertTrue("L'utente non è stato salvato correttamente", utente.equals(utente2) && flag);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM utente WHERE email = 'pippo@gmail.com'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doRetrieveAllTest() {
        List<Utente> listaUtenti = new ArrayList<Utente>();
        List<Utente> listaUtentiTest = null;
        Connection connection;

        Utente utente1, utente2;
        utente1 = new Utente();
        utente2 = new Utente();
        utente1.setId("e.coppola37@studenti.unisa.it");
        utente1.setPassword("Casdwa324$");
        utente1.setUsername("emmavico");
        utente2.setPassword("GIAcc7£");
        utente2.setId("pippo@gmail.com");
        utente2.setUsername("giaccarello");

        listaUtenti.add(utente1);
        listaUtenti.add(utente2);

        listaUtentiTest = dao.doRetrieveAll();
        boolean test1 = true;
        boolean test2 = true;
        for(Utente x: listaUtentiTest)
        {
            test1 = false;
            for(Utente y: listaUtenti)
            {
                if(x.equals(y))
                {
                    test1 = true;
                }
            }
            if(test1 == false)
            {
                test2 = false;
            }
        }

        assertTrue("La lista di utenti non è restituita correttamente", test2);

        try {
            connection = ConnPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM utente WHERE email = 'pippo@gmail.com'");
            statement.executeUpdate("DELETE FROM utente WHERE email = 'e.coppola37@studenti.unisa.it'");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}