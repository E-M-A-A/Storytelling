package Control.StoriaTest;

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

public class InserisciCommentoTest {
    CommentoDao dao = Mockito.mock(CommentoDao.class);

    @Test
    public void inserimentoTest(){
        Utente utente = new Utente();
        Commento commento = new Commento();
        commento.setUsername("emmavico");
        Mockito.when(dao.doSave(commento)).thenReturn(true);
        MockHttpServletRequest request = new MockHttpServletRequest();
        HttpSession session = request.getSession();
        session.setAttribute("utente",utente);
        request.setParameter("storia","1");
        request.setParameter("commento","hihi bellissimo");
    }




}
