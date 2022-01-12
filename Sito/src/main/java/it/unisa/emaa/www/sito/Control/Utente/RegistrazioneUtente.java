package it.unisa.emaa.www.sito.Control.Utente;

import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Questa servlet effettua la registrazione di un utente.
 * L'operazione fallisce se:
 * risulta che una chiave passata è già presente all'interno del database;
 * se la password non corrisponde alla password nella conferma password;
 * se email o password non seguono il pattern.
 * Utilizza i metodi statici della classe Validazione.
 * @see it.unisa.emaa.www.sito.Utils.Validazione
 * @author Alessandro Marigliano
 */
public class RegistrazioneUtente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordTest = req.getParameter("passwordTest");
        boolean eula = Boolean.parseBoolean(req.getParameter("eula"));
        if(!controllaDati(email,password,passwordTest,username,eula))
            resp.setStatus(500);
        password = Validazione.passwordHasher(password);
        Utente utente = new Utente();
        utente.setUsername(username);
        utente.setId(email.toLowerCase());
        utente.setPassword(password);
        if(!effettuaRegistrazione(utente))
            resp.setStatus(500);
        utente.setPassword("");
        session.setAttribute("Utente",utente);
    }

    private boolean effettuaRegistrazione(Utente utente){
        UtenteDao utenteDao = new UtenteDao();
        return utenteDao.doSave(utente);
    }

    private boolean controllaDati(String email,String password,String passwordTest,String username, boolean eula){
        return !Validazione.emailIsPresent(email) && !Validazione.usernameIsPresent(username) && Validazione.emailRegex(email) && Validazione.passwordRegex(password) && password.equals(passwordTest) && eula;
    }
}