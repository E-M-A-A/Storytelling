import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class TrovaSpammer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(2020);
        while(true) {
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            String jsonCommenti = (String) objectInputStream.readObject();
            Gson gson = new Gson();
            ArrayList<CommentoSemplice> commenti = gson.fromJson(jsonCommenti, new TypeToken<ArrayList<CommentoSemplice>>() {
            }.getType());
            ArrayList<String> utentiSpammer = controllaSpammer(commenti);
            String jsonSpammer = gson.toJson(utentiSpammer);
            objectOutputStream.writeObject(jsonSpammer);
        }
    }
    public static ArrayList<String> controllaSpammer(ArrayList<CommentoSemplice> commenti){
        TreeSet<String> utenti = new TreeSet<>();
        for(CommentoSemplice commento:commenti)
            utenti.add(commento.getUsername());
        ArrayList<String> spammers = new ArrayList<>();
        Random rand = new Random();
        for(String utente:utenti){
            if(rand.nextInt(50)>40)
                spammers.add(utente);
        }
        return spammers;
    }
}
