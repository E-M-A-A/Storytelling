package Model;

import it.unisa.emaa.www.sito.Model.ConnPool;
import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

/**La classe si occupa di testare la classe UtenteDao nei metodi di communicazione con il database
 * @author Emmanuele Virginio Coppola
 *
 * Questa classe di test � stata scritta secondo la
 * metodologia WHITE BOX.
 */
public class UtenteDaoTest{
    UtenteDao dao = new UtenteDao();
   Connection connection;
   String data1="INSERT INTO Utente VALUES('e.coppola37@studenti.unisa.it','Casdwa324$','emmavico'";
    String data2="INSERT INTO Utente VALUES('pippo@gmail.com','GIAcc7£','giaccarello'";

    @BeforeAll
    void setup() throws SQLException {
       connection= ConnPool.getConnection();
   }
   @AfterEach
   void rimozioneDatiTesting()  {

   }

   @Test
   void deleteTest(){
       try {
           Statement statement = connection.createStatement();
           statement.executeUpdate(data1);
           statement.executeUpdate(data2);
           connection.commit();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       dao.doDelete("pippo@gmail.com");
       try {
           Statement statement= connection.createStatement();
           String qry="Select * FROM Utente Where email = 'pippo@gmail.com'";
           ResultSet rs=statement.executeQuery(qry);
           assertEquals(true,!rs.isBeforeFirst());
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }

   @Test
    void testRetrieveByUsername() throws SQLException {
       Statement statement = connection.createStatement();
       String sql;
   }
    @Test
    void doRetrieveByEmail() throws SQLException {
        Statement statement = connection.createStatement();
        String sql;
    }

    @AfterEach
    public void tearDown() {
        try {
            Statement stmtSelect = conn.createStatement();
            String sql1 = ("DELETE FROM tirocinio WHERE CODTIROCINIO='1';");
            stmtSelect.executeUpdate(sql1);
            String sql2 = ("DELETE FROM tirocinante WHERE matricola='4859';");
            stmtSelect.executeUpdate(sql2);
            String sql3 = ("DELETE FROM enteconvenzionato WHERE partitaIva='11111111111';");
            stmtSelect.executeUpdate(sql3);
            String sql4 = ("DELETE FROM User WHERE email='p.aurilia@studenti.unisa.it';");
            stmtSelect.executeUpdate(sql4);
            String sql5 = ("DELETE FROM User WHERE email='green@gmail.com';");
            stmtSelect.executeUpdate(sql5);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Test del metodo allTirocinio di TirocinioDAO
    @Test
    void testAllTirocinio() {
        boolean trovato = false;
        int i;

        try {

            Statement stmtSelect = conn.createStatement();
            stmtSelect.executeUpdate(sql1);
            stmtSelect.executeUpdate(sql2);
            stmtSelect.executeUpdate(sql3);
            stmtSelect.executeUpdate(sql4);
            stmtSelect.executeUpdate(sql5);
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Tirocinio> listaTirocini = tirocinioDao.allTirocinio();
        for (i = 0; i < listaTirocini.size(); i++) {
            if (listaTirocini.get(i).getCodTirocinio() == 1
                    && listaTirocini.get(i).getMatricola() == 4859) {
                trovato = true;
            }
        }
        assertEquals(trovato, true);
    }


