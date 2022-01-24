package Control.UtenteTest;


import it.unisa.emaa.www.sito.Control.Utente.Login;
import it.unisa.emaa.www.sito.Control.Utente.RegistrazioneUtente;
import it.unisa.emaa.www.sito.Model.dao.CommentoDao;
import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RegistrazioneUtenteTest {
    UtenteDao dao = Mockito.mock(UtenteDao.class);
    Utente utente = new Utente();

    @Test
    public void registrazioneTest() throws IOException {

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("username", "emmavico");
        request.setParameter("email", "e.coppola37@studenti.unisa.it");
        request.setParameter("password", "Casdwa324");
        request.setParameter("passwordTest", "Casdwa324");

        request.setParameter("eula", "true");
        Utente utente = new Utente();
        utente.setUsername("emmavico");
        utente.setId("e.coppola37@studenti.unisa.it");
        try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest("Casdwa324".getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            // return the HashText
            utente.setPassword(hashtext);
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Mockito.when(dao.doSave(utente)).thenReturn(true);

        RegistrazioneUtente controller = new RegistrazioneUtente(dao);

        request.addHeader("referer", "ciao");
        controller.registrazioneUtente(request, response);
        utente.setPassword("");

        assertTrue("L'utente non è registrato correttamente", utente.equals(request.getSession().getAttribute("utente")));
    }

    @Test
    public void registrazioneEmailErrataTest() throws IOException {

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("username", "emmavico");
        request.setParameter("email", "emailerrata");
        request.setParameter("password", "Casdwa324");
        request.setParameter("passwordTest", "Casdwa324");

        request.setParameter("eula", "true");
        Utente utente = new Utente();
        utente.setUsername("emmavico");
        utente.setId("emailerrata");
        try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest("Casdwa324".getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            // return the HashText
            utente.setPassword(hashtext);
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Mockito.when(dao.doSave(utente)).thenReturn(true);

        RegistrazioneUtente controller = new RegistrazioneUtente(dao);

        request.addHeader("referer", "ciao");
        controller.registrazioneUtente(request, response);
        utente.setPassword("");

        assertTrue("L'email errata non è individuata correttamente", response.getStatus() == 500);
    }

    @Test
    public void registrazioneEmailEsistenteTest() throws IOException {

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("username", "emmavico");
        request.setParameter("email", "e.coppola37@studenti.unisa.it");
        request.setParameter("password", "Casdwa324");
        request.setParameter("passwordTest", "Casdwa324");

        request.setParameter("eula", "true");
        Utente utente = new Utente();
        utente.setUsername("emmavico");
        utente.setId("e.coppola37@studenti.unisa.it");
        try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest("Casdwa324".getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            // return the HashText
            utente.setPassword(hashtext);
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Mockito.when(dao.doSave(utente)).thenReturn(false);

        RegistrazioneUtente controller = new RegistrazioneUtente(dao);

        request.addHeader("referer", "ciao");
        controller.registrazioneUtente(request, response);
        utente.setPassword("");

        assertTrue("L'email già esistente non è individuata correttamente", response.getStatus() == 500);
    }

    @Test
    public void registrazionePasswordNonValidaTest() throws IOException {

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("username", "emmavico");
        request.setParameter("email", "e.coppola37@studenti.unisa.it");
        request.setParameter("password", "passwordnonvalida");
        request.setParameter("passwordTest", "passwordnonvalida");

        request.setParameter("eula", "true");
        Utente utente = new Utente();
        utente.setUsername("emmavico");
        utente.setId("e.coppola37@studenti.unisa.it");
        try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest("passwordnonvalida".getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            // return the HashText
            utente.setPassword(hashtext);
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Mockito.when(dao.doSave(utente)).thenReturn(true);

        RegistrazioneUtente controller = new RegistrazioneUtente(dao);

        request.addHeader("referer", "ciao");
        controller.registrazioneUtente(request, response);
        utente.setPassword("");

        assertTrue("La password errata non è individuata correttamente", response.getStatus() == 500);
    }

    @Test
    public void registrazionePasswordTestNonCoincidenteTest() throws IOException {

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("username", "emmavico");
        request.setParameter("email", "e.coppola37@studenti.unisa.it");
        request.setParameter("password", "Password1");
        request.setParameter("passwordTest", "Password2");

        request.setParameter("eula", "true");
        Utente utente = new Utente();
        utente.setUsername("emmavico");
        utente.setId("e.coppola37@studenti.unisa.it");
        try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest("Password1".getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            // return the HashText
            utente.setPassword(hashtext);
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Mockito.when(dao.doSave(utente)).thenReturn(true);

        RegistrazioneUtente controller = new RegistrazioneUtente(dao);

        request.addHeader("referer", "ciao");
        controller.registrazioneUtente(request, response);
        utente.setPassword("");

        assertTrue("La password Test non coincidente non è individuata correttamente", response.getStatus() == 500);
    }

    @Test
    public void registrazioneUsernameEsistenteTest() throws IOException {

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("username", "emmavico");
        request.setParameter("email", "e.coppola37@studenti.unisa.it");
        request.setParameter("password", "Casdwa324");
        request.setParameter("passwordTest", "Casdwa324");

        request.setParameter("eula", "true");
        Utente utente = new Utente();
        utente.setUsername("emmavico");
        utente.setId("e.coppola37@studenti.unisa.it");
        try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest("Casdwa324".getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            // return the HashText
            utente.setPassword(hashtext);
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Mockito.when(dao.doSave(utente)).thenReturn(false);

        RegistrazioneUtente controller = new RegistrazioneUtente(dao);

        request.addHeader("referer", "ciao");
        controller.registrazioneUtente(request, response);
        utente.setPassword("");

        assertTrue("L'username già esistente non è individuato correttamente", response.getStatus() == 500);
    }


}
