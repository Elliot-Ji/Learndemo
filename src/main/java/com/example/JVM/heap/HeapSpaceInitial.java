package com.example.JVM.heap;

/**
 * 1.设置堆内存大小的参数
 * -Xms : 设置堆空间(年轻代+老年代)的初始内存大小
 *     -X 是jvm运行参数
 *     ms 是memory start
 * -Xmx : 设置堆空间(年轻代+老年代)的最大内存大小
 *
 * 2.默认堆内存大小
 *      初始堆内存: 系统内存大小/64
 *      最大堆内存: 系统内存大小/4
 * 3.手动设置堆内存: -Xms600m -Xmx600m
 *      开发中建议初始堆内存和最大堆内存设置为相同的值
 *
 * 4.查看参数设置:方式一: 命令行: jps: 查看当前运行的进程 ---> jstat -gc 进程id:
 *              方式二: -XX:+PrintGCDetails
 */
public class HeapSpaceInitial {
    public static void main(String[] args) {
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //jvm虚拟机中的堆内存初始大小
        long initialMemory = Runtime.getRuntime().totalMemory()/1024/1024;
        //jvm虚拟机中的堆内存最大内存
        long maxMemory = Runtime.getRuntime().maxMemory()/1024/1024;

        System.out.println("堆初始内存大小: "+ initialMemory + "M");
        System.out.println("堆最大内存: " + maxMemory + "M");
    }

}
