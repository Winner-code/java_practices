package com.zookeeperClient;

import com.zookeeper.Znode;
import com.zookeeperServer.Service;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Test implements Watcher {
    public static void main(String[] args) {
        ZooKeeper zooKeeper = null;
        try {
            //获取节点信息
            zooKeeper = new ZooKeeper("192.168.0.110:2181,192.168.0.110:2182,192.168.0.110:2183", 15000, new Test());
            byte[] bytes = zooKeeper.getData("/gx/msg",new Test(),null);
            String url = new String(bytes);
            //订阅，相当于远程调用
            Service s = (Service) Naming.lookup(url);
            String result = s.demoService("Client");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }


    }

    public void process(WatchedEvent watchedEvent) {
        if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
            System.out.println("连接成功");
        }
    }
}
