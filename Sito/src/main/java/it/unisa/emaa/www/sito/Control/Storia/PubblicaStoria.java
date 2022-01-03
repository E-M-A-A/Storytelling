package it.unisa.emaa.www.sito.Control.Storia;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PubblicaStoria extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("Utente");
        String story = req.getParameter("Contenuto");
        StoriaDao storiaDao = new StoriaDao();
        storiaDao.doCreate(user.getUsername(),story);
    }
}
