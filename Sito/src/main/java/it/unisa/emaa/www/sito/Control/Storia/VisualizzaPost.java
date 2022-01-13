package it.unisa.emaa.www.sito.Control.Storia;

import com.google.gson.Gson;
import it.unisa.emaa.www.sito.Model.dao.CommentoDao;
import it.unisa.emaa.www.sito.Model.dao.StoriaDao;
import it.unisa.emaa.www.sito.Model.entity.Commento;
import it.unisa.emaa.www.sito.Model.entity.Post;
import it.unisa.emaa.www.sito.Model.entity.Storia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idStoria = Integer.parseInt(req.getParameter("storia"));
        Post post = recuperaPost(idStoria);
        Gson gson = new Gson();
        String json = gson.toJson(post);
        resp.setContentType("plain/text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(json);
        resp.sendRedirect("/Site_war_exploded/visualizzazionePost.jsp");
    }
    private Post recuperaPost(int idStoria){
        Storia storia = storiaDao.doRetrieveById(idStoria);
        ArrayList<Commento> listaCommenti = (ArrayList<Commento>) commentoDao.doRetrieveByStoria(idStoria);
        Post post = new Post();
        post.setStoria(storia);
        post.setCommenti(listaCommenti);
        return post;
    }
    public VisualizzaPost(CommentoDao commentoDao,StoriaDao storiaDao){
        this.commentoDao = commentoDao;
        this.storiaDao = storiaDao;
    }
    public VisualizzaPost(){
        commentoDao = new CommentoDao();
        storiaDao = new StoriaDao();
    }
}
