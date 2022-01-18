package it.unisa.emaa.www.sito.Control.Storia.Asincrono;

import com.google.gson.Gson;
import it.unisa.emaa.www.sito.Model.dao.ReazioneDao;
import it.unisa.emaa.www.sito.Model.dao.StoriaDao;
import it.unisa.emaa.www.sito.Model.entity.Storia;
import it.unisa.emaa.www.sito.Model.entity.StoriaReazioni;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CaricaStorie",urlPatterns = "/CaricaStorie")
public class CaricaStorie extends HttpServlet {
    private StoriaDao storiaDao;
    private ReazioneDao reazioneDao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("utente");
        String stringPagina = req.getParameter("pagina");
        if(obj == null || stringPagina == null){
            resp.setStatus(500);
            return;
        }
        Utente utente = (Utente) obj;
        int pagina = Integer.parseInt(stringPagina);
        ArrayList<StoriaReazioni> storieReazioni = recuperaListaStorie(pagina,utente.getId());
        Gson gson = new Gson();
        String json = gson.toJson(storieReazioni);
        resp.setContentType("plain/text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(json);
    }

    public ArrayList<StoriaReazioni> recuperaListaStorie(int pagina, String email) {
        ArrayList<StoriaReazioni> storieReazioni = new ArrayList<>();
        ArrayList<Storia> listaStorie = (ArrayList<Storia>) storiaDao.doRetrieveByPage(30,pagina*30);
        boolean present;
        for (Storia s : listaStorie) {
            StoriaReazioni storia = new StoriaReazioni();
            storia.setStoria(s);
            present = Validazione.reactionIsPresent(email, s.getId(), reazioneDao);
            storia.setReazionata(present);
            storieReazioni.add(storia);
        }
        return storieReazioni;
    }
    public CaricaStorie(){
        storiaDao = new StoriaDao();
        reazioneDao = new ReazioneDao();
    }
    public CaricaStorie(StoriaDao storiaDao,ReazioneDao reazioneDao){
        this.storiaDao = storiaDao;
        this.reazioneDao = reazioneDao;
    }
}
