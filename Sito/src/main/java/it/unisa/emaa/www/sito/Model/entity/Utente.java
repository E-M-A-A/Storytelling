package it.unisa.emaa.www.sito.Model.entity;

import javax.persistence.*;

@NamedQueries(
        @NamedQuery(name="retrieveAll",query= "Select u from Utente u")
)

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @Column(name = "email", nullable = false, length = 300)
    private String id;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}