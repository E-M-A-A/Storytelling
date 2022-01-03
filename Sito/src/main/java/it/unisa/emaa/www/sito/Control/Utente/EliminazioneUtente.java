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
        Utente utente = (Utente) session.getAttribute("utente");
        String password = req.getParameter("password");
        boolean matchedPassword = controllaDati(utente.getEmail(),password);
        if(!matchedPassword){
            session.setAttribute("LoginErrato",!matchedPassword);
            String referer = req.getHeader("referer");
            resp.sendRedirect(referer);
        }
        resp.getWriter().print(eliminaUtente(utente.getEmail()));
    }
    private boolean controllaDati(String email,String password){
        UtenteDao utenteDao = new UtenteDao();
        Utente utente = utenteDao.doRetrieveByEmail(email);
        String hashedPassword = Validazione.passwordHasher(password);
        return Validazione.passwordTest(utente.getPassword(),hashedPassword);
    }
    public static boolean eliminaUtente(String email){
        UtenteDao utenteDao = new UtenteDao();
        return utenteDao.doDelete(email);
    }
}
