package it.unisa.emaa.www.sito.Control.Storia;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VisualizzaBacheca extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pagina = Integer.parseInt(req.getParameter("Pagina"));
        StoriaDao storiaDao = new StoriaDao();
        ArrayList<Storia> listaStorie = storiaDao.doRetrieveStorie((pagina*10),10);
        Gson gson = new Gson();
        String json = gson.toJson(listaStorie);
        resp.setContentType("plain/text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(json);

    }
}
