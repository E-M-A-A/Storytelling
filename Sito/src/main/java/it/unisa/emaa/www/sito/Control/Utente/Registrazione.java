package it.unisa.emaa.www.sito.Control.Utente;

import it.unisa.emaa.www.sito.Control.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class Registrazione extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        Pattern patternEmail = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*\\d)(?=.*[@#$._%-])(?=.*[A-Z]).{8,16}$");
        String username = req.getParameter("Username");
        String email = req.getParameter("Email");
        String password = req.getParameter("Password");
        String passwordTest = req.getParameter("PasswordTest");
        if (!password.equals(passwordTest) || !patternEmail.matcher(email).matches() || !patternPassword.matcher(password).matches()) try {
            throw new Exception();
        } catch (Exception e) {
            resp.setStatus(500);
            throw new RuntimeException();
        }
        try {
            PasswordHasher passwordHasher = new PasswordHasher();
            password = passwordHasher.setPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email.toLowerCase());
        user.setPassword(password);
        UserDao userDao = new UserDao();
        try {
            synchronized (userDao) {
                if (!Validazione.emailIsPresent(email)&&!Validazione.usernameIsPresent(username)) {
                    userDao.doSave(user);
                    user.setPassword("");
                    session.setAttribute("user", user);
                    resp.sendRedirect(req.getParameter("referer"));
                } else {
                    req.setAttribute("errorDescription", "Email already used.");
                    throw new Exception();
                }
            }
        } catch (Exception throwables) {
            resp.setStatus(500);
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
}
