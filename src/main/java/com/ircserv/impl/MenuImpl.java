package com.ircserv.impl;

import com.ircserv.contstante.Constante;
import com.ircserv.inter.MenuInterface;
import com.ircserv.metier.Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuImpl extends UnicastRemoteObject implements MenuInterface {

    private int numServ;

    public MenuImpl(int port) throws RemoteException {
        super(port);
        this.numServ = 0;
    }

    @Override
    public int createNewServer() throws RemoteException {
        try {
            int port = Constante.PORT;
            LocateRegistry.getRegistry(port);

            Naming.rebind("//"+ Constante.IP+":"+port+"/serv"+numServ, new ServerImpl(port));
            return numServ++;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("echec : " + e);
        }
        return -1;
    }

    @Override
    public void deleteServer(int nbServ) {
        try {
            int port = Constante.PORT;
            LocateRegistry.getRegistry(port);

            Naming.unbind("//"+Constante.IP+":"+port+"/serv"+nbServ);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("echec : " + e);
        }
    }

    @Override
    public ArrayList<Server> findServerByUser(int userId) throws RemoteException {
        ArrayList<Server> servers = new ArrayList<>();
        servers.add(new Server(0, "mon serveur"));
        servers.add(new Server(2, "un autre serveur"));
        servers.add(new Server(3, "Ta mère le buisson"));
        return servers;
    }
}