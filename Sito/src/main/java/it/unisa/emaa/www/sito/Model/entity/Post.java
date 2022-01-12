package it.unisa.emaa.www.sito.Model.entity;

import java.util.ArrayList;

public class Post {
    private Storia storia;
    private ArrayList<Commento> commenti;
    public Post(){}
    public Storia getStoria(){ return storia;}
    public ArrayList<Commento> getCommenti(){return commenti;}
    public void setStoria(Storia storia){ this.storia = storia;}
    public void setCommenti(ArrayList<Commento> commenti){ this.commenti = commenti;}
}
