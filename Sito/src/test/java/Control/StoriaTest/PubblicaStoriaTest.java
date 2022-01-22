package Control.StoriaTest;

import it.unisa.emaa.www.sito.Control.Storia.PubblicaStoria;
import it.unisa.emaa.www.sito.Model.dao.CommentoDao;
import it.unisa.emaa.www.sito.Model.dao.StoriaDao;
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

public class PubblicaStoriaTest {

    @Test
    public void successoTest() throws IOException, ServletException {
        StoriaDao dao = Mockito.mock(StoriaDao.class);

        Utente utente = new Utente();
        Storia storia = new Storia();
        storia.setUsername("antonio");
        storia.setContenuto("blablablablablablablablablablablalba");
        storia.setDataCreazione(LocalDate.now());

        Mockito.when(dao.doSave(storia)).thenReturn(true);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("username","antonio");
        request.setParameter("contenuto","blablablablablablablablablablablalba");

        PubblicaStoria controller = new PubblicaStoria(dao);
        controller.pubblicaStoria(request,response);
        assertTrue(response.getStatus()==200);




    }

    @Test
    public void contenutoMinoreDi1() throws ServletException, IOException {
        StoriaDao dao = Mockito.mock(StoriaDao.class);

        Utente utente = new Utente();
        Storia storia = new Storia();
        storia.setUsername("antonio");
        storia.setContenuto("b");
        storia.setDataCreazione(LocalDate.now());

        Mockito.when(dao.doSave(storia)).thenReturn(true);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("username","antonio");
        request.setParameter("contenuto","b");

        PubblicaStoria controller = new PubblicaStoria(dao);
        controller.pubblicaStoria(request,response);

        assertTrue(response.getStatus()==200);   // da controllare numero di confronto status




    }

    @Test
    public void contenutoMaggioreDi500() throws ServletException, IOException {
        StoriaDao dao = Mockito.mock(StoriaDao.class);

        Utente utente = new Utente();
        Storia storia = new Storia();
        storia.setUsername("antonio");
        storia.setContenuto("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        storia.setDataCreazione(LocalDate.now());

        Mockito.when(dao.doSave(storia)).thenReturn(true);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("username","antonio");
        request.setParameter("contenuto","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        PubblicaStoria controller = new PubblicaStoria(dao);
        controller.pubblicaStoria(request,response);
        assertTrue(response.getStatus()==200);   // da controllare numero di confronto status

    }







}
