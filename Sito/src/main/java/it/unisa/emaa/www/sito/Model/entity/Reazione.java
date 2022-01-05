package it.unisa.emaa.www.sito.Model.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name="retrieveByEmail",query="select r from Reazione r where r.")



})



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
    }  // da chiedere a manu dopo

}