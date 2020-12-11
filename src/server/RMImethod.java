/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author User
 */
public interface RMImethod extends Remote{
    public List<ModelStruktural> getStruktural()throws RemoteException;
    public String insertstrukutal(ModelStruktural ms) throws RemoteException;
    public String updatestruktural(int id, ModelStruktural ms) throws RemoteException;
    public String deletestrukutal(int id) throws RemoteException;
    
    public List<ModelSejarah> getSejarah()throws RemoteException;
    public String insertsejarah(ModelSejarah s) throws RemoteException;
    public String updatesejarah(int id, ModelSejarah s) throws RemoteException;
    public String deletesejarah(int id) throws RemoteException;
   
    public List<ModelNamaAngkatan> getNamaAngkatan()throws RemoteException;
    public String insertnamaangkatan(ModelNamaAngkatan mn) throws RemoteException;
    public String updatenamaangkatan(int id, ModelNamaAngkatan mn) throws RemoteException;
    public String deletenamaangkatan(int id) throws RemoteException;
   
    
}
