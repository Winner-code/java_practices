package com.zookeeperServer;

import com.zookeeper.Znode;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Test implements Watcher {
    public static void main(String[] args) {
        try {
            //实例化
            Service s = new ServiceImpl();
            //注册
            LocateRegistry.createRegistry(8888);
            //绑定
            Naming.bind("rmi://localhost:8888/zoo",s);
            //创建节点，将信息放入接点，方便调用
            ZooKeeper zooKeeper = new ZooKeeper("192.168.0.110:2181,192.168.0.110:2182,192.168.0.110:2183", 15000, new Znode());
            zooKeeper.create("/gx/msg","rmi://localhost:8888/zoo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("服务发布成功");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public void process(WatchedEvent watchedEvent) {
        //获取连接事件
        if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
            System.out.println("连接成功");
        }
    }
}
