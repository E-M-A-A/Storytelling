package Control;

import it.unisa.emaa.www.sito.Model.dao.CommentoDao;
import it.unisa.emaa.www.sito.Model.dao.ICommentoDao;
import it.unisa.emaa.www.sito.Model.entity.Commento;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;


import static org.mockito.Mockito.verify;

public class Testerino {
    @Test
    public void Ciao() {
        Commento commento = new Commento();
        commento.setUsername("username");
        commento.setContenuto("contenuto");
        commento.setIdStoria(2);
        CommentoDao commentoDao = (CommentoDao) Mockito.mock(ICommentoDao.class);
        commentoDao.doSave(commento);
        ArgumentCaptor<Commento> argumentCaptor = ArgumentCaptor.forClass(Commento.class);
        verify(commentoDao).doSave(argumentCaptor.capture());
        Commento capturedArgument = argumentCaptor.<Commento> getValue();
        //assertThat(capturedArgument, is(commento));
    }
}
