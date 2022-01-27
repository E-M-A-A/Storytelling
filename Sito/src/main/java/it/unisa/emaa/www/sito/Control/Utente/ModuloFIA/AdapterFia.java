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
import java.util.List;

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
                    List<Commento> commenti = commentoDao.doRetrieveAll();
                    ArrayList<Commento> commentiList = commenti==null?new ArrayList<>():new ArrayList<>(commenti);
                    String json = gson.toJson(commentiList);
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("plain/text");
                    resp.getWriter().print(json);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "invio":
                String json = gson.toJson(messaggio.getUtenti());

                break;
        }
    }
}
