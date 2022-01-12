package it.unisa.emaa.www.sito.Control.Storia;

import it.unisa.emaa.www.sito.Model.dao.ReazioneDao;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Questa servlet gestisce l'inserimento di una reazione da parte di un utente.
 * L'operazione fallisce se la reazione è già presente.
 * @author Alessandro Marigliano
 */
public class InserisciReazione extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Utente utente = (Utente) session.getAttribute("utente");
        int idStoria = Integer.parseInt(req.getParameter("storia"));
        inserimentoReazione(utente.getId(),idStoria);
    }
    private boolean inserimentoReazione(String email,int idStoria){
        ReazioneDao reazioneDao = new ReazioneDao();
        if(Validazione.reactionIsPresent(email,idStoria))
            resp.setStatus(500);
        reazioneDao.doSave(email,idStoria);
    }
}
