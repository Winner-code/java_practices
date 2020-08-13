package com.zookeeperServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote {
    String demoService(String str) throws RemoteException;
}
