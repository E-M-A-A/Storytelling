package it.unisa.emaa.www.sito.Control.Utente;


import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EliminazioneUtente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        String password = req.getParameter("password");
        UtenteDao utenteDao = new UtenteDao();
        Utente utente = utenteDao.doRetrieveUtente(email);
        String hashedPassword = Validazione.passwordHasher(password);
        boolean matchedPassword = false;
        if(!Validazione.passwordTest(utente.getPassword(),hashedPassword)){
            session.setAttribute("LoginErrato",matchedPassword);
            String referer = req.getHeader("referer");
            resp.sendRedirect(referer);
        }
    }
    public static boolean eliminaUtente(email){

    }
}
