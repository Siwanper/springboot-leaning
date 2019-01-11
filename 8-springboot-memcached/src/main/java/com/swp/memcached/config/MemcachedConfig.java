package com.swp.memcached.config;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-11 4:57 PM
 */
@Configuration
public class MemcachedConfig {

    @Value(value = "${memcache.servers}")
    private String[] servers;
    @Value(value = "${memcache.failover}")
    private boolean failover;
    @Value(value = "${memcache.initConn}")
    private int initConn;
    @Value(value = "${memcache.minConn}")
    private int minConn;
    @Value(value = "${memcache.maxConn}")
    private int maxConn;
    @Value(value = "${memcache.maintSleep}")
    private int maintSleep;
    @Value(value = "${memcache.nagel}")
    private boolean nagel;
    @Value(value = "${memcache.socketTO}")
    private int socketTO;
    @Value(value = "${memcache.aliveCheck}")
    private boolean aliveCheck;

    @Bean
    public SockIOPool pool(){

        SockIOPool pool = SockIOPool.getInstance();
        pool.setServers(servers);
        // 如果有多个可以配置权重
//        pool.setWeights();
        pool.setFailover(failover);
        // 设置初始连接数、最小连接数、最大连接数、最大处理时间
        pool.setInitConn(initConn);
        pool.setMinConn(minConn);
        pool.setMaxConn(maxConn);
        //设置连接池守护线程的睡眠时间
        pool.setMaintSleep(maintSleep);
        pool.setNagle(nagel);
        pool.setSocketTO(socketTO);
        //初始化并启动连接池
        pool.initialize();

        return pool;
    }

    @Bean
    public MemCachedClient memCachedClient(){
        return new MemCachedClient();
    }


}
