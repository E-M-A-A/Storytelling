package it.unisa.emaa.www.sito.Data.entity;

import java.util.ArrayList;

/**
 * Classe realizzata per mettere assieme storia e commenti

*/
public class Post {
    private Storia storia;
    private ArrayList<Commento> commenti;
    private Boolean reazione;


/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return storia.equals(post.storia) && Objects.equals(commenti, post.commenti) && Objects.equals(reazione, post.reazione);
    }*/


    public Post(){}
    public void setStoria(Storia storia){ this.storia = storia;}
    public void setCommenti(ArrayList<Commento> commenti){ this.commenti = commenti;}
    public void setReazione(Boolean reazione){ this.reazione=reazione;}
}
