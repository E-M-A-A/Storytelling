package it.unisa.emaa.www.sito.Control.Utente;


import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name="EliminazioneUtente",value = "/EliminazioneUtente")
public class EliminazioneUtente extends HttpServlet {
    private UtenteDao utenteDao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        eliminazioneUtente(req,resp);
    }
    public void eliminazioneUtente(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("utente");
        if(obj == null){
            resp.setStatus(403);
            return;
        }
        Utente utente = (Utente) obj;
        String password = req.getParameter("password");
        boolean matchedPassword = Validazione.datiCorrispondenti(utente.getId(),password,utenteDao);
        session.setAttribute("LoginErrato", !matchedPassword);
        if(!matchedPassword||!eliminaUtente(utente.getId())){
            String referer = req.getHeader("referer");
            resp.sendRedirect(referer);
        }
        session.setAttribute("utente",null);
        session.setAttribute("eliminato",true);
        resp.sendRedirect("/Sito_war_exploded");
    }
    /**
     * Il metodo elimina l'utente con l'email data dal database.
     * @param email L'email dell'utente che si vuole eliminare.
     * @return Il metodo ritorna il risultato dell'operazione.
     */
    public boolean eliminaUtente(String email){
        return utenteDao.doDelete(email);
    }
    public EliminazioneUtente(){
        utenteDao = new UtenteDao();
    }
    public EliminazioneUtente(UtenteDao utenteDao){
        this.utenteDao = utenteDao;
    }
}
