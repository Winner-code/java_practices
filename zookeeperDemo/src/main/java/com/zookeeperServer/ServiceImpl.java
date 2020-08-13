package com.zookeeperServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements Service {
    protected ServiceImpl() throws RemoteException {
    }

    public String demoService(String str) throws RemoteException {
        return str+"zookeeperServer";
    }
}
