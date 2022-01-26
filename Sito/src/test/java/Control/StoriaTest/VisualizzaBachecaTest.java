package Control.StoriaTest;

import it.unisa.emaa.www.sito.Control.Storia.VisualizzaBacheca;
import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Scotellaro
 * Testing per l'avvenuto successo di visualizzazione bacheca dove viene controllata la presenza dell'utente in sessione
 */


public class VisualizzaBachecaTest {
    @Test
    public void successoTest() throws ServletException, IOException {

        Utente utente = new Utente();

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);

        VisualizzaBacheca controller = new VisualizzaBacheca();
        controller.visualizzaBacheca(request, response);
        assertTrue(response.getStatus()==200);



    }
}
