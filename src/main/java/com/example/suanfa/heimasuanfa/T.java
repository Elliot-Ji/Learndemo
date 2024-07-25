package com.example.suanfa.heimasuanfa;

import cn.hutool.core.lang.Assert;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 黑马出品，算法与数据结构
 * 1.基础数据结构
 * 2.基础算法
 * 3.进阶算法
 * @author Elliot Ji
 * @date 2024/02/20
 */
public class T {
    private final static Set<String> allowedOrigins = new HashSet<>(Arrays.asList(
            "https://wx.jiangdu.gov.cn",
            "https://dsj.wx.jiangdu.gov.cn",
            "https://admin.wx.jiangdu.gov.cn/",
            "https://zhfw.wx.jiangdu.gov.cn/",
            "https://wxzck.wx.jiangdu.gov.cn/" ,
            "https://zljs.wx.jiangdu.gov.cn/" ,
            "https://zlcp.wx.jiangdu.gov.cn/" ,
            "https://jrfw.wx.jiangdu.gov.cn/" ,
            "https://jzpg.wx.jiangdu.gov.cn/" ,
            "https://zlyy.wx.jiangdu.gov.cn/"));
    public static void main(String[] args) {

        boolean contains = allowedOrigins.contains("https://wx.jiangdu.gov.cn/");
        System.out.println(contains);
        Object s = "[苏州瑞红电子化学品有限公司, 江南大学]";
        String[] ff = (String[])s;
        System.out.println(ff);
    }

    public static Executor updateIndustry() {
        int coreNum = Runtime.getRuntime().availableProcessors();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数：线程池创建时候初始化的线程数
        executor.setCorePoolSize(coreNum);
        // 最大线程数：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程   260  280  15
        // if (coreNum < 3) {
        executor.setMaxPoolSize(10);    //此时会报错，maxPoolSize的数量必须大于corePoolSize
        // } else {
        //     executor.setMaxPoolSize(coreNum + 1);
        // }
        // 缓存队列
        executor.setQueueCapacity(10000);
        // 允许线程的空闲时间2h：当超过了核心线程之外的线程在空闲时间到达之后会被销毁
        executor.setKeepAliveSeconds(2 * 60 * 60);
        // 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
        executor.setThreadNamePrefix("update-industry-");
        /**
         * 当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize，如果还有任务到来就会采取任务拒绝策略
         * 通常有以下四种策略：
         * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
         * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
         * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
         * ThreadPoolExecutor.CallerRunsPolicy：重试添加当前的任务，自动重复调用 execute() 方法，直到成功
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }


}
