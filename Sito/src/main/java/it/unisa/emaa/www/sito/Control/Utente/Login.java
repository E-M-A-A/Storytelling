package it.unisa.emaa.www.sito.Control.Utente;

import it.unisa.emaa.www.sito.Control.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            synchronized (session) {
                String hashedPassword = Validazione.passwordHasher(password);
                UserDao userDao = new UserDao();
                User user = userDao.doRetrieveByEmail(email);
                boolean failedLogin = true;
                if (user!=null && hashedPassword.equals(user.getPassword())) {
                    failedLogin = false;
                    user.setPassword("");
                    session.setAttribute("user", user);
                }
                session.setAttribute("failedLogin", failedLogin);
                String referer = req.getHeader("referer");
                resp.sendRedirect(referer);
            }
        } catch (NoSuchAlgorithmException | SQLException e) {
            e.printStackTrace();
        }
    }
}
