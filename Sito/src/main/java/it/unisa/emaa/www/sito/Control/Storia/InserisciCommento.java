package it.unisa.emaa.www.sito.Control.Storia;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InserisciCommento extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Utente user = session.getAttribute("utente");
        int idStoria = Integer.parseInt(req.getParameter("storia"));
        String commento = req.getParameter("commento");
        CommentoDao commentoDao = new CommentoDao();
        commentoDao.doCreate(commento,idStoria);
    }
}
