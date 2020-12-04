package com.atguigu.jvm;

/**
 * @author LHF
 * @date 2020/12/4 14:47
 *
 * 在Run-EditConfigurations的VMOptions里添加参数
 * -Xms1024m -Xmx1024m -XX:+PrintGCDetails
 *
 * -Xms：Java虚拟机中的内存总量为1024M
 * -Xmx：设置Java虚拟机试图使用的最大内存量为1024M
 * -XX:+PrintGCDetails：打印GC详情日志
 */
public class HeapOptimize {

    public static void main(String[] args){
        long maxMemory = Runtime.getRuntime().maxMemory();//返回Java虚拟机试图使用的最大内存量
        long totalMemory = Runtime.getRuntime().totalMemory();//返回Java虚拟机中的内存总量
        System.out.println("-Xmx:MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("-Xms:TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");
    }

}
