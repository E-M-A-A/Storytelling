package it.unisa.emaa.www.sito.Control.Storia;

import com.google.gson.Gson;
import it.unisa.emaa.www.sito.Model.dao.StoriaDao;
import it.unisa.emaa.www.sito.Model.entity.Storia;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VisualizzaBacheca extends HttpServlet {
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
        StoriaDao storiaDao = new StoriaDao();
        return storiaDao.doRetrieveByPage(pagina*10,10);

    }
}
