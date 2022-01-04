package it.unisa.emaa.www.sito.Control.Utente;

import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrazioneUtente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordTest = req.getParameter("passwordTest");
        boolean eula = Boolean.parseBoolean(req.getParameter("eula"));
        if(!controlloDati(email,password,passwordTest,username,eula))
            resp.setStatus(500);
        password = Validazione.passwordHasher(password);
        Utente utente = new Utente();
        utente.setUsername(username);
        utente.setEmail(email.toLowerCase());
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

    private boolean controlloDati(String email,String password,String passwordTest,String username, boolean eula){
        return !Validazione.emailIsPresent(email) && !Validazione.usernameIsPresent(username) && Validazione.emailRegex(email) && Validazione.passwordRegex(password) && Validazione.passwordTest(password, passwordTest) && eula;
    }
}
