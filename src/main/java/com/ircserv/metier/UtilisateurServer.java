package com.ircserv.metier;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "utilisateur_serveur")
public class UtilisateurServer implements Serializable {
    private int id;
    private Utilisateur user;
    private Server server;

    public UtilisateurServer() {
        this.id = -1;
    }

    public UtilisateurServer(Utilisateur user, Server server) {
        this.user = user;
        this.server = server;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "no_utilisateur")
    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "code_serveur")
    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }


}
