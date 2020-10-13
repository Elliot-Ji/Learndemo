package com.example.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * 案例:服务器动态上下线通知
 */
public class DistributServer {
    private String connectString = "192.168.23.145:2181,192.168.23.146:2181,192.168.23.147:2181";
    private int sessionTimeOut = 2000;
    private ZooKeeper zkClient;

    public static void main(String[] args) throws Exception {
        DistributServer server = new DistributServer();
        //1.连接zookeeper集群
        server.getConnect();
        //2.注册节点
        server.register(args[0]);
        //3.业务逻辑处理
        server.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void register(String hostname) throws KeeperException, InterruptedException {
        //注册的节点类型是临时,有序的(-e,-s)
        String path = zkClient.create("/servers/server", hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostname + " is online");
    }

    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeOut, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

}
