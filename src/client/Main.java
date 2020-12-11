/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.Crud;

/**
 *
 * @author kasmira
 */
public class Main {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(9099);
        Crud crud = new Crud();
        registry.rebind("rmiServer", crud);
        System.out.println("Server RMI Jalan");
        new Mulai().setVisible(true);
    }
}
