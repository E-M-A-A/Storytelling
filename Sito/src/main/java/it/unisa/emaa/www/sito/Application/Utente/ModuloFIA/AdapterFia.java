package it.unisa.emaa.www.sito.Application.Utente.ModuloFIA;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.unisa.emaa.www.sito.Data.dao.CommentoDao;
import it.unisa.emaa.www.sito.Data.entity.Commento;
import it.unisa.emaa.www.sito.Data.entity.Utente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdapterFia{

    public static ArrayList<String> utentiSpammer(ArrayList<Commento> commenti) throws IOException, ClassNotFoundException {
        Gson gson = new Gson();
        String jsonCommenti = gson.toJson(commenti);
        Socket socket = new Socket("localhost",2020);
        if(!socket.isConnected()){
            throw new RuntimeException("Connessione alla socket non riuscita");
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(jsonCommenti);
        String jsonUtenti = (String) objectInputStream.readObject();
        return gson.fromJson(jsonUtenti,new TypeToken<ArrayList<String>>(){}.getType());
    }
}
