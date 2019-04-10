package com.ee.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class NodeCache_Sample {
    static String path = "/zk-book/nodecache";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("192.168.1.100:2181,192.168.1.100:2182,192.168.1.100:2183")
            .sessionTimeoutMs(5000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();

    public static void main(String[] args) throws Exception {
        client.start();
        client.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath(path, "init".getBytes());

        final NodeCache cache = new NodeCache(client, path, false);
        cache.start(true);
        cache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("Node data update, new date: " + new String(cache.getCurrentData().getData()));
            }
        });
        client.setData().forPath(path, "u".getBytes());
        System.out.println("update");
        Thread.sleep(1000);
        client.delete().deletingChildrenIfNeeded().forPath(path);
        System.out.println("delete");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
