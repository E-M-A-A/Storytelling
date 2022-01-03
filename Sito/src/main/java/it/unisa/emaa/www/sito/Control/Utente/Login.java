package it.unisa.emaa.www.sito.Control.Utente;

import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean failedLogin = true;
        if(!controllaUtente(email,password)) {
            session.setAttribute("LoginErrato",failedLogin);
            String referer = req.getHeader("referer");
            resp.sendRedirect(referer);
        }
        UtenteDao utenteDao = new UtenteDao();
        Utente utente = utenteDao.doRetrieveUtente(email);
        utente.setPassword("");
        session.setAttribute("Utente",utente);
        session.setAttribute("LoginErrato",failedLogin);
    }

    private boolean controllaUtente(String email,String password){
        if(!Validazione.emailIsPresent(email))
            return false;
        String hashedPassword = Validazione.passwordHasher(password);
        UtenteDao utenteDao = new UtenteDao();
        Utente utente = utenteDao.doRetrieveUtente(email);
        if(!Validazione.passwordTest(hashedPassword,utente.getPassword()))
            return false;
        return true;
        }
    }
}
