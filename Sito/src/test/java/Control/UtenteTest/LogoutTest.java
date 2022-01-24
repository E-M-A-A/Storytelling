package Control.UtenteTest;

import it.unisa.emaa.www.sito.Control.Utente.Login;
import it.unisa.emaa.www.sito.Control.Utente.Logout;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertFalse;

public class LogoutTest  {
    /*
    @Test
    public void logoutSuccessoTest()
    {
        Utente utente = new Utente();
        utente.setUsername("emmavico");
        utente.setId("e.coppola37@studenti.unisa.it");
        try
        {
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
        catch(
                NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        MockHttpSession session = (MockHttpSession) request.getSession();

        session.setAttribute("utente", utente);

        Logout controller = new Logout();

        request.addHeader("referer", "ciao");
        controller.doGet(request, response);
        assertFalse("Il logout è stato ",  ((boolean)request.getAttribute("LoginRiuscito")));


    }
    */
}
