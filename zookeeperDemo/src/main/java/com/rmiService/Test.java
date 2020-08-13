package com.rmiService;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Test {
    public static void main(String[] args) {
        try {
            RmiService rmi = new RmiServiceImpl();
            LocateRegistry.createRegistry(8888);
            Naming.bind("rim://localhost:8888/RmiService",rmi);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
