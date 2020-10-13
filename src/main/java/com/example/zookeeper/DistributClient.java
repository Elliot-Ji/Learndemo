package com.example.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DistributClient {
    private String connectString = "192.168.23.145:2181,192.168.23.146:2181,192.168.23.147:2181";
    private int sessionTimeOut = 2000;
    private ZooKeeper zkClient;
    public static void main(String[] args) throws Exception {
        DistributClient client = new DistributClient();
        //1.连接zookeeper集群
        client.getConnect();
        //2.注册监听
        client.getChildren();
        //3.业务处理
        client.buisness();
    }

    private void buisness() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/servers", true);
        List<String> hosts = new ArrayList<>();
        for(String child : children){
            byte[] data = zkClient.getData("/servers/" + child, false, null);
            hosts.add(new String(data));
        }
        System.out.println(hosts);
    }

    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeOut, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    getChildren();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
