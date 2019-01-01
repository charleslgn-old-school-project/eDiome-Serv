package com.ircserv;

import com.ircserv.contstante.Constante;
import com.ircserv.impl.MenuImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        //System.setProperty("java.rmi.server.hostname","home.rscharff.fr");
        //Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Shutdown Hook is running !")));
        try {
            int port = Constante.PORT;
            MenuImpl obj = new MenuImpl(port);
            LocateRegistry.createRegistry(port);
            Naming.rebind("//"+Constante.IP+":" + port + "/menu", obj);
            System.out.println("server ready");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("echec : " + e);
        }
    }
}