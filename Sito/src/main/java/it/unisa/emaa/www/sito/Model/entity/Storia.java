package it.unisa.emaa.www.sito.Model.entity;

import javax.persistence.*;
import java.time.LocalDate;




@Entity
@Table(name = "storia")
public class Storia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "contenuto", nullable = false, length = 512)
    private String contenuto;

    @Column(name = "nReazioni", nullable = false)
    private Integer nReazioni;

    @Column(name = "nCommenti", nullable = false)
    private Integer nCommenti;

    @Column(name = "dataCreazione", nullable = false)
    private LocalDate dataCreazione;

    public LocalDate getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDate dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Integer getNCommenti() {
        return nCommenti;
    }

    public void setNCommenti(Integer nCommenti) {
        this.nCommenti = nCommenti;
    }

    public Integer getNReazioni() {
        return nReazioni;
    }

    public void setNReazioni(Integer nReazioni) {
        this.nReazioni = nReazioni;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}