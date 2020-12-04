package com.atguigu.jvm;

import java.util.Random;

/**
 * @author LHF
 * @date 2020/12/4 14:59
 *
 *  OOM
 *
 *  Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *
 *
 *  参数改为-Xms10m -Xmx10m -XX:+PrintGCDetails
 *
 * GC收集日志信息
 *
 *  [GC (Allocation Failure)
 *      GC的类型 Minor GC  新生代满了，就会GC采用复制算法
 *
 *  [PSYoungGen: 2032K->490K(2560K)] 2032K->734K(9728K), 0.0029059 secs]
 *      PSYoungGen为新生代 2032K为YoungGC前新生代内存占用 490K为GC之后的，（2560K）为新生代总大小
 *      第二个2032K为YGC之前JVM堆内存占用，734K为YGC之后堆内存占用
 *      0.0029059 secs为YGC耗时
 *
 *  [Times: user=0.08 sys=0.00, real=0.00 secs]
 *      YGC：user用户耗时
 *      YGC：sys系统耗时
 *      YGC：real实际耗时
 *
 *
 *  [Full GC (Ergonomics)
 *      Major GC 老年代满了，GC新生代和老年代，
 *  [PSYoungGen: 1751K->0K(2560K)]
 *  [ParOldGen: 7117K->1822K(7168K)] 8869K->1822K(9728K),
 *  [Metaspace: 3502K->3502K(1056768K)], 0.0049150 secs]
 *  [Times: user=0.00 sys=0.00, real=0.01 secs]
 */
public class OOM_GC {

    public static void main(String[] args){
        String str = "lhf";
        while (true){
            str += str + new Random().nextInt(88888888) + new Random().nextInt(99999999);
        }
    }

}
