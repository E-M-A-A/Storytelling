package it.unisa.emaa.www.sito.Control.Storia.Asincrono;

import com.google.gson.Gson;
import it.unisa.emaa.www.sito.Model.dao.ReazioneDao;
import it.unisa.emaa.www.sito.Model.dao.StoriaDao;
import it.unisa.emaa.www.sito.Model.entity.Storia;
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
import java.util.HashMap;
@WebServlet(name="caricaStorie",value = "/caricaStorie")
public class CaricaStorie extends HttpServlet {
    private StoriaDao storiaDao;
    private ReazioneDao reazioneDao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession sessione = req.getSession(false);
         Utente utente= (Utente) sessione.getAttribute("utente");
         String email = utente.getId();
         String inputPagina= req.getParameter("pagina");
        int pagina = Integer.parseInt(inputPagina);
        Gson gson = new Gson();
        HashMap<String, Boolean> storieReazioni = recuperaListaStorie(pagina,email,gson);

        String json = gson.toJson(storieReazioni);
        resp.setContentType("plain/text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(json);
    }

    public HashMap<String,Boolean> recuperaListaStorie(int pagina, String email,Gson gson) {
        HashMap<String, Boolean> storieReazioni = new HashMap<>();
        ArrayList<Storia> listaStorie = (ArrayList<Storia>) storiaDao.doRetrieveByPage(30,pagina*30);
        boolean present;
        for (Storia s : listaStorie) {
            present = Validazione.reactionIsPresent(email, s.getId(), reazioneDao);
            storieReazioni.put(gson.toJson(s), present);
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
