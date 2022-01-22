package it.unisa.emaa.www.sito.Control.Utente.ModuloFIA;

import java.util.ArrayList;

public class Messaggio {
    private String operazione;
    private String passCode;
    private ArrayList<String> utenti;
    public Messaggio(String operazione,String passCode,ArrayList<String> utenti){
        this.operazione = operazione;
        this.passCode = passCode;
        this.utenti = utenti;
    }
    public String getOperazione(){
        return operazione;
    }
    public String getPassCode(){
        return passCode;
    }
    public ArrayList<String> getUtenti(){
        return utenti;
    }
}
