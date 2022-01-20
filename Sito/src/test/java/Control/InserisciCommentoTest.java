package Control;

import it.unisa.emaa.www.sito.Model.dao.CommentoDao;
import it.unisa.emaa.www.sito.Model.dao.ICommentoDao;
import it.unisa.emaa.www.sito.Model.entity.Commento;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpSession;

public class InserisciCommentoTest {
    CommentoDao dao = Mockito.mock(CommentoDao.class);

    @Test
    public void inserimentoTest(){

        Utente utente = new Utente();
        Mockito.when(dao.doSave("molto bello hihi").thenReturn(true));
        MockHttpServletRequest sex = new MockHttpServletRequest();
        HttpSession session = sex.getSession();
        session.setAttribute("utente",utente);
        sex.setParameter("storia","1");
        sex.setParameter("commento","hihi bellissimo");



    }




}
