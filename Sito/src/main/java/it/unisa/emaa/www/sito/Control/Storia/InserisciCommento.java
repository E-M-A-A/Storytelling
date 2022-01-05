package it.unisa.emaa.www.sito.Control.Storia;

import it.unisa.emaa.www.sito.Model.entity.Utente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Questa servlet gestisce l'inserimento di un commento relativo a una storia.
 * L'operazione fallisce se il commento non rispetta la regola di lunghezza.
 * @author Alessandro Marigliano
 */
public class InserisciCommento extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Utente utente = (Utente) session.getAttribute("utente");
        int idStoria = Integer.parseInt(req.getParameter("storia"));
        String commento = req.getParameter("commento");
        resp.getWriter().print(inserimentoCommento(utente.getUsername(),idStoria,commento));
    }
    private boolean inserimentoCommento(String username,int idStoria,String commento){
        if(commento.length()<3||commento.length()>100)
            return false;
        CommentoDao commentoDao = new CommentoDao();
        Commento commento = new Commento();
        commento.setUtente();
        commento.setCommento();
        commento.setIdStoria();
        return commentoDao.doSave(commento);
    }
}
