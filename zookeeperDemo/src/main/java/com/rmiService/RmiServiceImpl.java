package com.rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 接口实现类必须继承UnicastRemoteObject
 * 添加构造方法
 */
public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {
    //protected修改为public
    public RmiServiceImpl() throws RemoteException {
    }

    public String demo(String str) throws RemoteException {
        return str+"01";
    }
}
