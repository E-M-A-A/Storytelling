package it.unisa.emaa.www.sito.Model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reazione")
public class Reazione {
    @EmbeddedId
    private ReazioneId id;

    public ReazioneId getId() {
        return id;
    }

    public void setId(ReazioneId id) {
        this.id = id;
    }
}