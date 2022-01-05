package it.unisa.emaa.www.sito.Control.Storia;

import it.unisa.emaa.www.sito.Model.dao.StoriaDao;
import it.unisa.emaa.www.sito.Model.entity.Storia;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import sun.util.resources.LocaleData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

public class PubblicaStoria extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Utente utente = (Utente) session.getAttribute("utente");
        String storia = req.getParameter("contenuto");
        resp.getWriter().print(pubblicaStoria(utente.getUsername(),storia));
    }

    private boolean pubblicaStoria(String username,String contenuto){
        StoriaDao storiaDao = new StoriaDao();
        Storia storia = new Storia();
        storia.setContenuto(contenuto);
        storia.setUsername(username);
        storia.setNCommenti(0);
        storia.setNReazioni(0);
        storia.setDataCreazione(LocalDate.now());
        storiaDao.doSave(storia);
    }
}
