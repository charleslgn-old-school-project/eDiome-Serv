package com.ircserv.inter;

import com.ircserv.metier.Droit;
import com.ircserv.metier.Message;
import com.ircserv.metier.Server;
import com.ircserv.metier.Utilisateur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface ServerInterface extends Remote{
    List<Message> getMessages() throws RemoteException;
    List<Message> getMessages(int nbLastMessage) throws RemoteException;
    void send(int userId, int servId, String message) throws RemoteException;
    void uploadFile(int userId, int servId, byte[] data, String filename) throws RemoteException;
    List<Utilisateur> getAllUserNotInServer() throws RemoteException;
    List<Utilisateur> getAllUserInServer() throws RemoteException;
    void linkUserToServer(Utilisateur utilisateur) throws RemoteException;
    Droit getDroit(Utilisateur utilisateur) throws RemoteException;
}
