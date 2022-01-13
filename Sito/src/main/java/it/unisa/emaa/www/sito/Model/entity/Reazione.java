package it.unisa.emaa.www.sito.Model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *Classe entity Reazione che è il rispettivo della tabella reazione all'interno della base di dati
 * contiene gli attributi della tabella come variabili ed i metodi get e set utili per l'esecuzione
 * del design pattern dao
 *
 * @author Antonio Scotellaro
 *
 *

 */



public class Reazione implements Serializable {
        public int getIdStoria() {
                return idStoria;
        }

        public void setIdStoria(int idStoria) {
                this.idStoria = idStoria;
        }

        public String getEmailUtente() {
                return emailUtente;
        }

        public void setEmailUtente(String emailUtente) {
                this.emailUtente = emailUtente;
        }

        @Override
        public String toString() {
                return "Reazione{" +
                        "idStoria=" + idStoria +
                        ", emailUtente='" + emailUtente + '\'' +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Reazione reazione = (Reazione) o;
                return idStoria == reazione.idStoria && emailUtente.equals(reazione.emailUtente);
        }

        @Override
        public int hashCode() {
                return Objects.hash(idStoria, emailUtente);
        }

        private int idStoria;
        private String emailUtente;
}