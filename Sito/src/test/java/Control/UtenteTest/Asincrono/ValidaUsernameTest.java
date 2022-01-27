package Control.UtenteTest.Asincrono;

import it.unisa.emaa.www.sito.Control.Utente.Asincrono.ValidaEmail;
import it.unisa.emaa.www.sito.Control.Utente.Asincrono.ValidaUsername;
import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidaUsernameTest {

    @Test
    public void validaTest() throws IOException {
        UtenteDao dao = Mockito.mock(UtenteDao.class);
        Utente utente = new Utente();

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("username", "emmavico");

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
        catch (
                NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Mockito.when(dao.doRetrieveByUsername("emmavico")).thenReturn(utente);

        ValidaUsername controller = new ValidaUsername(dao);

        request.addHeader("referer", "ciao");
        controller.validaUsername(request, response);

        Assert.assertEquals("L'username non è presente ed ha fatto crashare la funzione", response.getStatus(), 200);
        assertTrue(Boolean.parseBoolean(response.getContentAsString()));

    }


    @Test
    public void validaUsernameNonPresenteTest() throws IOException {
        UtenteDao dao = Mockito.mock(UtenteDao.class);
        Utente utente = new Utente();

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("username", "questousernamenonesiste");

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
        catch (
                NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Mockito.when(dao.doRetrieveByUsername("questousernamenonesiste")).thenReturn(null);

        ValidaUsername controller = new ValidaUsername(dao);

        request.addHeader("referer", "ciao");
        controller.validaUsername(request, response);

        Assert.assertEquals("L'username non corretta ha fatto crashare la funzione", response.getStatus(), 200);
        Assert.assertNotEquals("true",response.getContentAsString());

    }

}
