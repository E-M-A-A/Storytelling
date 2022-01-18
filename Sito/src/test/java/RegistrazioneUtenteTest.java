import it.unisa.emaa.www.sito.Control.Utente.RegistrazioneUtente;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.test.web.servlet.result.RequestResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RegistrazioneUtenteTest {
    private MockMvc controllerCaller;

    @Before
    public void setUp(){
        controllerCaller = MockMvcBuilders.
                standaloneSetup(new RegistrazioneUtente()).build();
    }

    @Test
    public void testFunzionante() throws Exception {
        MockHttpServletRequest req= new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

    }






}
