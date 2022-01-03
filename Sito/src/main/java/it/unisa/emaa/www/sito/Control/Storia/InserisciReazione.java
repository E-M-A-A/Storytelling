package it.unisa.emaa.www.sito.Control.Storia;

import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InserisciReazione extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ReazioneDao reazioneDao = new ReazioneDao();
        Utente utente = session.getAttribute("utente");
        int idStoria = Integer.parseInt(req.getParameter("storia"));
        if(Validazione.reactionIsPresent(utente.getEmail(),idStoria))
            resp.setStatus(500);
        reazioneDao.doCreate(utente.getEmail(),idStoria);
    }
}
