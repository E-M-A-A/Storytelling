package it.unisa.emaa.www.sito.Model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class Reazione implements Serializable {
        @EmbeddedId
        private Reazione id;

        public Reazione getId() {
                return id;
        }

        public void setId(Reazione id) {
                this.id = id;
        }


        private static final long serialVersionUID = 2566138142846125823L;
        @Column(name = "idStoria", nullable = false)
        private Integer idStoria;
        @Column(name = "emailUtente", nullable = false, length = 300)
        private String emailUtente;

        public String getEmailUtente() {
        return emailUtente;
        }

        public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
        }

public Integer getIdStoria() {
        return idStoria;
        }

public void setIdStoria(Integer idStoria) {
        this.idStoria = idStoria;
        }

@Override
public int hashCode() {
        return Objects.hash(idStoria, emailUtente);
        }

@Override
public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reazione entity = (Reazione) o;
        return Objects.equals(this.idStoria, entity.idStoria) &&
        Objects.equals(this.emailUtente, entity.emailUtente);
        }
        }