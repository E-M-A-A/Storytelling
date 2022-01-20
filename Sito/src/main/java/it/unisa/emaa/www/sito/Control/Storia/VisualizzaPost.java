package it.unisa.emaa.www.sito.Control.Storia;

import com.google.gson.Gson;
import it.unisa.emaa.www.sito.Model.dao.CommentoDao;
import it.unisa.emaa.www.sito.Model.dao.ReazioneDao;
import it.unisa.emaa.www.sito.Model.dao.StoriaDao;
import it.unisa.emaa.www.sito.Model.entity.Commento;
import it.unisa.emaa.www.sito.Model.entity.Post;
import it.unisa.emaa.www.sito.Model.entity.Storia;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Questa servlet gestisce la visualizzazione di una storia con i relativi commenti.
 * Crea un oggetto Post che contiene le due entità.
 * @author Alessandro Marigliano
 */
@WebServlet(name = "VisualizzaPost",urlPatterns = "/VisualizzaPost")
public class VisualizzaPost extends HttpServlet {
    private CommentoDao commentoDao;
    private StoriaDao storiaDao;
    private ReazioneDao reazioneDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String idStoriaString = req.getParameter("storia");
        Object obj = session.getAttribute("utente");
        if(obj == null){
            resp.setStatus(403);
            return;
        }
        if(idStoriaString==null){
            resp.setStatus(500);
            return;
        }
        int idStoria = Integer.parseInt(idStoriaString);
        Utente utente = (Utente) obj;
        String email = utente.getId();
        Post post = recuperaPost(idStoria,email);
        Gson gson = new Gson();
        String json = gson.toJson(post);
        req.setAttribute("post",json);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/visualizzazionePost.jsp");
        dispatcher.forward(req,resp);
    }
    private Post recuperaPost(int idStoria,String email){
        Storia storia = storiaDao.doRetrieveById(idStoria);
        ArrayList<Commento> listaCommenti = (ArrayList<Commento>) commentoDao.doRetrieveByStoria(idStoria);
        Post post = new Post();
        post.setStoria(storia);
        post.setCommenti(listaCommenti);
        post.setReazione(Validazione.reactionIsPresent(email,idStoria,reazioneDao));
        return post;
    }
    public VisualizzaPost(CommentoDao commentoDao,StoriaDao storiaDao,ReazioneDao reazioneDao){
        this.commentoDao = commentoDao;
        this.storiaDao = storiaDao;
        this.reazioneDao = reazioneDao;
    }
    public VisualizzaPost(){
        commentoDao = new CommentoDao();
        storiaDao = new StoriaDao();
        reazioneDao = new ReazioneDao();
    }
}
