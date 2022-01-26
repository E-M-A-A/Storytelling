package Control.StoriaTest.Asincrono;

import it.unisa.emaa.www.sito.Control.Storia.Asincrono.InserisciReazione;
import it.unisa.emaa.www.sito.Model.dao.ReazioneDao;
import it.unisa.emaa.www.sito.Model.entity.Reazione;
import it.unisa.emaa.www.sito.Model.entity.Storia;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Scotellaro
 * testing per l'inserimento di reazione all'interno di una storia. Viene testato il caso di successo dove viene effettuato
 * l'inserimento in modo corretto e il caso di fallimento dove la reazione è già presente.

 */



public class InserisciReazioneTest {
    @Test
    public void successoTest(){
        ReazioneDao dao =  Mockito.mock(ReazioneDao.class);
        Utente utente = new Utente();
        Storia storia = new Storia();
        Reazione reazione = new Reazione();
        storia.setUsername("antonio");
        storia.setId(1);
        storia.setContenuto("blablablablablablablablablablablalba");
        storia.setDataCreazione(LocalDate.now());

        utente.setId("ciao@gmail.com");
        utente.setUsername("emmavico");



        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("storia","1");

        reazione.setIdStoria(1);
        reazione.setEmailUtente("ciao@gmail.com");

        Mockito.when(dao.doSave(reazione)).thenReturn(true);
        Mockito.when(dao.doRetrieve("ciao@gmail.com", 1)).thenReturn(null);


        InserisciReazione controller = new InserisciReazione(dao);
        controller.inserisciReazione(request,response);
        assertEquals(200,response.getStatus());


    }
    @Test
    public void reazionePresenteTest(){
        ReazioneDao dao =  Mockito.mock(ReazioneDao.class);
        Utente utente = new Utente();
        Storia storia = new Storia();
        Reazione reazione = new Reazione();
        storia.setUsername("antonio");
        storia.setId(1);
        storia.setContenuto("blablablablablablablablablablablalba");
        storia.setDataCreazione(LocalDate.now());

        utente.setId("ciao@gmail.com");
        utente.setUsername("emmavico");



        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("referer","ciao");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("storia","1");

        reazione.setIdStoria(1);
        reazione.setEmailUtente("ciao@gmail.com");

        Mockito.when(dao.doSave(reazione)).thenReturn(true);
        Mockito.when(dao.doRetrieve("ciao@gmail.com", 1)).thenReturn(reazione);


        InserisciReazione controller = new InserisciReazione(dao);
        controller.inserisciReazione(request,response);
        assertEquals(500,response.getStatus());


    }


}
