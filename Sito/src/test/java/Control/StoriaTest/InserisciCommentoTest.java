package Control.StoriaTest;

import it.unisa.emaa.www.sito.Control.Storia.InserisciCommento;
import it.unisa.emaa.www.sito.Model.dao.CommentoDao;
import it.unisa.emaa.www.sito.Model.dao.ICommentoDao;
import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Commento;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * @author Antonio Scotellaro
 * Testing per l'inserimento commento, vengono testati i casi di successo inserimento e di fallimento inserimento nel momento in cui
 * non è presente l'utente, l'id storia di riferimento, il commento e i casi dove il commento è minore di 3 e maggiore di 100
 *
 */



public class InserisciCommentoTest {


    @Test
    public void successoTest() throws IOException {
        CommentoDao dao = Mockito.mock(CommentoDao.class);

        Utente utente = new Utente();
        Commento commento = new Commento();
        utente.setId("ciao@gmail.com");
        utente.setUsername("emmavico");
        commento.setUsername("emmavico");
        commento.setContenuto("hihi bellissimo");
        commento.setIdStoria(1);

        Mockito.when(dao.doSave(commento)).thenReturn(true);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");
        MockHttpServletResponse response = new MockHttpServletResponse();
        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("storia","1");
        request.setParameter("commento","hihi bellissimo");

        InserisciCommento controller = new InserisciCommento(dao);
        controller.inserisciCommento(request, response);
        assertEquals(302,response.getStatus());



    }
    @Test
    public void noUtenteTest() throws IOException {
        CommentoDao dao = Mockito.mock(CommentoDao.class);

        Commento commento = new Commento();
        commento.setUsername("nicola");
        commento.setContenuto("ciaoo");
        commento.setIdStoria(1);

        Mockito.when(dao.doSave(commento)).thenReturn(true);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer", "ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        request.setParameter("storia","1");
        request.setParameter("commento","ciaoo");

        InserisciCommento controller = new InserisciCommento(dao);
        controller.inserisciCommento(request, response);
        assertTrue(response.getStatus()==403);


    }
    @Test
    public void noIdStoriaTest() throws IOException{
        CommentoDao dao = Mockito.mock(CommentoDao.class);

        Utente utente = new Utente();
        Commento commento = new Commento();
        commento.setUsername("marco");
        commento.setContenuto("ciaoo");
        commento.setIdStoria(1);

        Mockito.when(dao.doSave(commento)).thenReturn(true);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer", "ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("commento","hihi bellissimo");

        InserisciCommento controller = new InserisciCommento(dao);
        controller.inserisciCommento(request, response);
        assertTrue(response.getStatus()==500);

    }

    @Test
    public void noCommentoTest() throws  IOException{
        CommentoDao dao = Mockito.mock(CommentoDao.class);

        Utente utente = new Utente();
        Commento commento = new Commento();
        commento.setUsername("marco");
        commento.setContenuto("ciaoo");
        commento.setIdStoria(1);

        Mockito.when(dao.doSave(commento)).thenReturn(true);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer", "ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("storia","1");

        InserisciCommento controller = new InserisciCommento(dao);
        controller.inserisciCommento(request, response);
        assertTrue(response.getStatus()==500);


    }

    @Test
    public void commentoMinore3() throws IOException {
        CommentoDao dao = Mockito.mock(CommentoDao.class);

        Utente utente = new Utente();
        Commento commento = new Commento();
        commento.setUsername("emmavico");
        commento.setContenuto("hi");
        commento.setIdStoria(1);

        Mockito.when(dao.doSave(commento)).thenReturn(true);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("storia","1");
        request.setParameter("commento","hi");

        InserisciCommento controller = new InserisciCommento(dao);
        controller.inserisciCommento(request, response);
        assertTrue(response.getStatus()==500); // da sistemare il return false nella servlet InserisciCommento


    }
    @Test
    public void commentoMaggioreDi100() throws IOException{
        CommentoDao dao = Mockito.mock(CommentoDao.class);

        Utente utente = new Utente();
        Commento commento = new Commento();
        commento.setUsername("emmavico");
        commento.setContenuto("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        commento.setIdStoria(1);

        Mockito.when(dao.doSave(commento)).thenReturn(true);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("storia","1");
        request.setParameter("commento","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        InserisciCommento controller = new InserisciCommento(dao);
        controller.inserisciCommento(request, response);
        assertTrue(response.getStatus()==500); // da sistemare il return false nella servlet InserisciCommento
    }




}
