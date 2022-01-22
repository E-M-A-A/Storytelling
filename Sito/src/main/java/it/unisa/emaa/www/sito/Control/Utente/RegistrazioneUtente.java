package it.unisa.emaa.www.sito.Control.Utente;

import it.unisa.emaa.www.sito.Model.dao.UtenteDao;
import it.unisa.emaa.www.sito.Model.entity.Utente;
import it.unisa.emaa.www.sito.Utils.Validazione;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Questa servlet effettua la registrazione di un utente.
 * L'operazione fallisce se:
 * risulta che una chiave passata è già presente all'interno del database;
 * se la password non corrisponde alla password nella conferma password;
 * se email o password non seguono il pattern.
 * Utilizza i metodi statici della classe Validazione.
 * @see it.unisa.emaa.www.sito.Utils.Validazione
 * @author Alessandro Marigliano
 */
@WebServlet(name = "RegistraUtente",urlPatterns = "/RegistraUtente")
public class RegistrazioneUtente extends HttpServlet {
    private UtenteDao utenteDao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        registrazioneUtente(req,resp);
    }

    public void registrazioneUtente(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordTest = req.getParameter("passwordTest");
        boolean eula = Boolean.parseBoolean(req.getParameter("eula"));
        if(!controllaDati(email,password,passwordTest,username,eula)) {
            resp.setStatus(500);
            return;
        }
        password = Validazione.passwordHasher(password);
        Utente utente = new Utente();
        utente.setUsername(username);
        utente.setId(email.toLowerCase());
        utente.setPassword(password);
        if(!effettuaRegistrazione(utente)) {
            resp.setStatus(500);
            return;
        }
        utente.setPassword("");
        session.setAttribute("utente",utente);
        resp.sendRedirect("./VisualizzaHome");

    }
    private boolean effettuaRegistrazione(Utente utente){
        return utenteDao.doSave(utente);
    }

    private boolean controllaDati(String email,String password,String passwordTest,String username, boolean eula){
        boolean emailPresente = Validazione.emailIsPresent(email,utenteDao);
        boolean emailUsername = Validazione.usernameIsPresent(username,utenteDao);
        boolean emailRegex = Validazione.emailRegex(email);
        boolean passwordRegex = Validazione.passwordRegex(password);
        boolean passwordEquals = password.equals(passwordTest);
        return !emailPresente&&!emailUsername&&emailRegex&&passwordRegex&&passwordEquals;
    }
    public RegistrazioneUtente(){
        utenteDao = new UtenteDao();
    }
    public RegistrazioneUtente(UtenteDao utenteDao){
        this.utenteDao = utenteDao;
    }
}
