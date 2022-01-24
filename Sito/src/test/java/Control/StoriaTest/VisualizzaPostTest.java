package Control.StoriaTest;

import it.unisa.emaa.www.sito.Control.Storia.InserisciCommento;
import it.unisa.emaa.www.sito.Control.Storia.VisualizzaPost;
import it.unisa.emaa.www.sito.Model.dao.CommentoDao;
import it.unisa.emaa.www.sito.Model.entity.Commento;
import it.unisa.emaa.www.sito.Model.entity.Storia;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class VisualizzaPostTest {
    @Test
    public void successoTest() throws ServletException, IOException {


        VisualizzaPost dao = Mockito.mock(VisualizzaPost.class);

        Utente utente = new Utente();
        Storia storia = new Storia();
        storia.setUsername("antonio");
        storia.setContenuto("blablablablablablablablablablablalba");
        storia.setDataCreazione(LocalDate.now());;


        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("username","antonio");
        request.setParameter("contenuto","blablablablablablablablablablablalba");

        VisualizzaPost controller = new VisualizzaPost(dao);
        controller.visualizzaPost(request, response);
        assertTrue(response.getStatus()==302);




    }
    @Test
    public void noUtenteTest() throws ServletException, IOException {
        VisualizzaPost dao = Mockito.mock(VisualizzaPost.class);

        Storia storia = new Storia();
        storia.setUsername("antonio");
        storia.setContenuto("blablablablablablablablablablablalba");
        storia.setDataCreazione(LocalDate.now());

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        request.setParameter("username","antoio");
        request.setParameter("contenuto","blablablablablablablablablablablalba");

        VisualizzaPost controller = new VisualizzaPost(dao);
        controller.visualizzaPost(request, response);
        assertTrue(response.getStatus()==403);
    }

    @Test
    public void noStoriaTest() throws ServletException, IOException {
        VisualizzaPost dao = Mockito.mock(VisualizzaPost.class);

    Utente utente = new Utente();



    MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");

    MockHttpServletResponse response = new MockHttpServletResponse();

    HttpSession session = request.getSession();
        session.setAttribute("utente",utente);

    VisualizzaPost controller = new VisualizzaPost(dao);
        controller.visualizzaPost(request, response);
    assertTrue(response.getStatus()==500);
}


}
