import it.unisa.emaa.www.sito.Control.Utente.RegistrazioneUtente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrazioneUtenteTest {
    public String username,email,password,passwordTest;
    public boolean eula,oracolo;

    public RegistrazioneUtenteTest(
            String username,String email,String password,String passwordTest,boolean eula,boolean oracolo
    ){
        this.username=username;
        this.email=email;
        this.password=password;
        this.passwordTest=passwordTest;
        this.eula=eula;
        this.oracolo=oracolo;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {"","bellissimo@gmail.com","Disney.3","Disney.3",true,false},
                {"pippopaologianfrancogianni","bellissimo@gmail.com","Disney.3","Disney.3",true,true},
                {"pippo","bellissimo@gmail.com","Disney33","Disney33",true,false}
        });
    }
    @Test public void controllaDatiTest(){
        assertTrue("Test di Controllo",oracolo== RegistrazioneUtente.controllaDati(email,password,passwordTest,username,eula));
    }



}
