package com.rmiClient;

import com.rmiService.RmiServiceImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Test  {
    public static void main(String[] args) {
        try {
            RmiService rmi = (RmiService) Naming.lookup("rmi://localhost:8888/demoService");
            String client = rmi.demo("client");
            System.out.println(client);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
