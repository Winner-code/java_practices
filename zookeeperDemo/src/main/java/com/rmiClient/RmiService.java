package com.rmiClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiService extends Remote {
    String demo(String str) throws RemoteException;
}
