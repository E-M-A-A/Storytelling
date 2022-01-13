package it.unisa.emaa.www.sito.Control.Storia;

import it.unisa.emaa.www.sito.Model.dao.CommentoDao;
import it.unisa.emaa.www.sito.Model.entity.Commento;
import it.unisa.emaa.www.sito.Model.entity.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "InserisciCommento",urlPatterns = "/InserisciCommento")
public class InserisciCommento extends HttpServlet {
    private CommentoDao commentoDao;
  /*  @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Utente utente = (Utente) session.getAttribute("utente");
        int idStoria = Integer.parseInt(req.getParameter("storia"));
        String commento = req.getParameter("commento");
        resp.getWriter().print(inserimentoCommento(utente.getUsername(),idStoria,commento));
        resp.sendRedirect(req.getHeader("referer"));
    }
    private boolean inserimentoCommento(String username,int idStoria,String contenuto){
        if(contenuto.length()<3||contenuto.length()>100)
            return false;
        Commento commento = new Commento();
        commento.setUsername(username);
        commento.setContenuto(contenuto);
        commento.setIdStoria(idStoria);
        return commentoDao.doSave(commento);
    }*/
    public InserisciCommento(){
        commentoDao = new CommentoDao();
    }
    public InserisciCommento(CommentoDao commentoDao){
        this.commentoDao = commentoDao;
    }
}
