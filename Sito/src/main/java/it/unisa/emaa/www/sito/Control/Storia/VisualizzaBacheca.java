package it.unisa.emaa.www.sito.Control.Storia;

import com.google.gson.Gson;
import it.unisa.emaa.www.sito.Model.dao.StoriaDao;
import it.unisa.emaa.www.sito.Model.entity.Storia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa servlet gestisce la visualizzazione della bacheca(homepage).
 * Viene richiesto il numero di pagina per selezionare solo una parte delle storie da visualizzare.
 * @author Alessandro Marigliano
 */
@WebServlet(name = "VisualizzaBacheca",urlPatterns = "/VisualizzaBacheca")
public class VisualizzaBacheca extends HttpServlet {
    private StoriaDao storiaDao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pagina = Integer.parseInt(req.getParameter("pagina"));
        ArrayList<Storia> listaStorie = (ArrayList<Storia>) recuperaListaStorie(pagina);
        Gson gson = new Gson();
        String json = gson.toJson(listaStorie);
        resp.setContentType("plain/text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(json);
    }
    private List<Storia> recuperaListaStorie(int pagina){
        return storiaDao.doRetrieveByPage(pagina*30,30);
    }
    public VisualizzaBacheca(){
        storiaDao = new StoriaDao();
    }
    public VisualizzaBacheca(StoriaDao storiaDao){
        this.storiaDao = storiaDao;
    }
}
