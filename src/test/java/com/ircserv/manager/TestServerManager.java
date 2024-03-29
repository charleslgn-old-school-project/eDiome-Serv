package com.ircserv.manager;

import com.ircserv.metier.Server;
import com.ircserv.metier.Utilisateur;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestServerManager {
    private ServerManager serverManager;
    private int id;
    private Server server;

    @Before
    public void initData(){
        serverManager = new ServerManager();
    }

    @Test
    @Ignore
    public void TestCreate(){
        UtilisateurManager utilisateurManager = new UtilisateurManager();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("test");
        utilisateur.setPrenom("test");
        utilisateur.setIdentifiant("test");
        utilisateur.setMailPro("");
        utilisateur.setPassword("test");
        utilisateur.setTelephonePro("");

        utilisateur = utilisateurManager.create(utilisateur);
        server = new Server("test", utilisateur);
        Server serverTest = serverManager.create(server);

        assertEquals(serverTest.getCreateur(), server.getCreateur());
        assertEquals(serverTest.getName(), server.getName());
    }

    @Test
    @Ignore
    public void testDelete(){}

}
