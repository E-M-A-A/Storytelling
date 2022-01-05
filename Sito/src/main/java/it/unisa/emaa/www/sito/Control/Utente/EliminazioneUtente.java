package it.unisa.emaa.www.sito.Control.Utente;


import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Questa servlet effettua l'eliminazione di un utente dal database.
 * L'operazione fallisce se la password data non corrisponde a quella dell'utente.
 * @author Alessandro Marigliano
 */
public class EliminazioneUtente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Utente utente = (Utente) session.getAttribute("utente");
        String password = req.getParameter("password");
        boolean matchedPassword = Validazione.datiCorrispondenti(utente.getEmail(),password);
        if(!matchedPassword){
            session.setAttribute("LoginErrato",!matchedPassword);
            String referer = req.getHeader("referer");
            resp.sendRedirect(referer);
        }
        resp.getWriter().print(eliminaUtente(utente.getEmail()));
    }
    /**
     * Il metodo elimina l'utente con l'email data dal database.
     * @param email L'email dell'utente che si vuole eliminare.
     * @return Il metodo ritorna il risultato dell'operazione.
     */
    public static boolean eliminaUtente(String email){
        UtenteDao utenteDao = new UtenteDao();
        return utenteDao.doDelete(email);
    }
}
