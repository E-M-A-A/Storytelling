package it.unisa.emaa.www.sito.Control.Storia;

import com.google.gson.Gson;
import it.unisa.emaa.www.sito.Control.Utente.Asincrono.CaricaStorie;
import it.unisa.emaa.www.sito.Model.dao.ReazioneDao;
import it.unisa.emaa.www.sito.Model.dao.StoriaDao;
import it.unisa.emaa.www.sito.Model.entity.Storia;
import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Questa servlet gestisce la visualizzazione della bacheca(homepage).
 * Viene richiesto il numero di pagina per selezionare solo una parte delle storie da visualizzare.
 * @author Alessandro Marigliano
 */
@WebServlet(name = "VisualizzaHome",urlPatterns = "/VisualizzaHome")
public class VisualizzaBacheca extends HttpServlet {
    private StoriaDao storiaDao;
    private ReazioneDao reazioneDao;
    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pagina = Integer.parseInt(req.getParameter("pagina"));
        ArrayList<Storia> listaStorie = (ArrayList<Storia>) recuperaListaStorie(pagina);
        Gson gson = new Gson();
        String json = gson.toJson(listaStorie);
        resp.setContentType("plain/text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(json);
    }*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pagina = Integer.parseInt(req.getParameter("pagina"));
        String email = req.getParameter("email");
        HashMap<Storia,Boolean> storieReazioni = new CaricaStorie(storiaDao,reazioneDao).recuperaListaStorie(pagina,email);
        Gson gson = new Gson();
        String json = gson.toJson(storieReazioni);
        resp.setContentType("plain/text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(json);
    }
    public VisualizzaBacheca(){
        storiaDao = new StoriaDao();
        reazioneDao = new ReazioneDao();
    }
    public VisualizzaBacheca(StoriaDao storiaDao, ReazioneDao reazioneDao){
        this.storiaDao = storiaDao;
        this.reazioneDao = reazioneDao;
    }
}
