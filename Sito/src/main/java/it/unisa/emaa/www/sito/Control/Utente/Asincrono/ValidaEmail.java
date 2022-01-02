package it.unisa.emaa.www.sito.Control.Utente.Asincrono;

import it.unisa.emaa.www.sito.Control.Utils.Validazione;
import it.unisa.emaa.www.sito.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidaEmail extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("Email");
        resp.setContentType("plain/text");
        resp.setCharacterEncoding("UTF-8");
        if(Validazione.emailIsPresent(email))
            resp.getWriter().print("true");
        else
            resp.getWriter().print("false");
    }
}
