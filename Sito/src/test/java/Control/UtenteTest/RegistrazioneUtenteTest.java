package Control.UtenteTest;


import it.unisa.emaa.www.sito.Control.Utente.RegistrazioneUtente;
import it.unisa.emaa.www.sito.Model.dao.CommentoDao;
import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;
import java.security.MessageDigest;


public class RegistrazioneUtenteTest {
    UtenteDao dao = Mockito.mock(UtenteDao.class);
    Utente utente = new Utente();

    @Test
    public void doPostTest()
    {
        /*
        MockHttpServletRequest richiesta = new MockHttpServletRequest();
        richiesta.setParameter("username", "emmavico");
        richiesta.setParameter("email", "e.coppola37@studenti.unisa.it");
        richiesta.setParameter("password", "Casdwa324");
        richiesta.setParameter("eula", "true");
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
        RegistrazioneUtente regUtente = new RegistrazioneUtente(dao);
        MockHttpServletResponse risposta = new MockHttpServletResponse();
        WebApplicationContext wac = ...;

        MockMvc mockMvc = webAppContextSetup(wac).build();

        mockMvc.perform(post("/form"))
                .andExpect(status().isOk())
                .andExpect(content().mimeType("text/html"))
                .andExpect(forwardedUrl("/WEB-INF/layouts/main.jsp"));

        */

    }


}
