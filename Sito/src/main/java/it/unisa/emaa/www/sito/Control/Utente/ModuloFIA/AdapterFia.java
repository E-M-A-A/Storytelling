package it.unisa.emaa.www.sito.Control.Utente.ModuloFIA;

import com.google.gson.Gson;
import it.unisa.emaa.www.sito.Model.dao.CommentoDao;
import it.unisa.emaa.www.sito.Model.entity.Commento;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdapterFia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringa = req.getParameter("messaggio");
        Gson gson = new Gson();
        Messaggio messaggio = gson.fromJson(stringa,Messaggio.class);
        switch (messaggio.getOperazione()){
            case "ricezione":
                CommentoDao commentoDao = new CommentoDao();
                try {
                    ArrayList<Commento> commenti = (ArrayList<Commento>) commentoDao.doRetrieveAll();
                    String json = gson.toJson(commenti);
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("plain/text");
                    resp.getWriter().print(json);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "invio":

                break;
        }
    }
}
