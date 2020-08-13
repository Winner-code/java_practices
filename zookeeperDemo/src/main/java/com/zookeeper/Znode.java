package com.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class Znode implements Watcher {
    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.0.110:2181,192.168.0.110:2182,192.168.0.110:2183", 15000, new Znode());
            //创建节点
            zooKeeper.create("/gx/service02","number01".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);

            //获取节点中的数据
            byte[] data = zooKeeper.getData("/gx/service01", new Znode(), new Stat());
            System.out.println(new String(data));
            List<String> children = zooKeeper.getChildren("/gx", new Znode());
            for (String path:children){
                byte[] data1 = zooKeeper.getData("/gx/" + path, new Znode(), new Stat());
                System.out.println(new String(data1));
            }


            //设置节点
            Stat stat = zooKeeper.setData("/gx/service01", "01".getBytes(), -1);
            System.out.println(stat);

            //删除节点
            zooKeeper.delete("/gx/service0000000001",-1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected){
            System.out.println("连接成功");
        }

    }
}
