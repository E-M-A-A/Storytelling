package it.unisa.emaa.www.sito.Application.Utente.ModuloFIA;


import it.unisa.emaa.www.sito.Data.dao.CommentoDao;
import it.unisa.emaa.www.sito.Data.dao.UtenteDao;
import it.unisa.emaa.www.sito.Data.entity.Commento;
import it.unisa.emaa.www.sito.Data.entity.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletionException;

public class EliminazioneSpammer extends HttpServlet{
    @Override
    public void init() throws ServletException {
       super.init();
       TaskFia task = new TaskFia();
        Timer t = new Timer();
        t.scheduleAtFixedRate(task,0,86400000);
    }
    private static class TaskFia extends TimerTask {
        @Override
        public void run() {
            System.out.println("Task avviato");
            CommentoDao commentoDao = new CommentoDao();
            try {
                List<Commento> commentoList = commentoDao.doRetrieveAll();
                if(commentoList==null)
                    return;
                ArrayList<Commento> commenti = new ArrayList<>(commentoList);
                ArrayList<String> utentiUsername = AdapterFia.utentiSpammer(commenti);
                UtenteDao utenteDao = new UtenteDao();
                for(String username:utentiUsername){
                    Utente utente = utenteDao.doRetrieveByUsername(username);
                    utenteDao.doDelete(utente.getId());
                }
            } catch (SQLException | ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
