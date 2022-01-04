package it.unisa.emaa.www.sito.Model.entity;

import javax.persistence.*;

@Entity
@Table(name = "commento")
public class Commento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idStoria", nullable = false)
    private Storia idStoria;

    @ManyToOne(optional = false)
    @JoinColumn(name = "username", nullable = false)
    private Utente username;

    @Column(name = "contenuto", nullable = false, length = 128)
    private String contenuto;

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public Utente getUsername() {
        return username;
    }

    public void setUsername(Utente username) {
        this.username = username;
    }

    public Storia getIdStoria() {
        return idStoria;
    }

    public void setIdStoria(Storia idStoria) {
        this.idStoria = idStoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}