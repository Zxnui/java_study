package threadPool;

import java.util.concurrent.*;

/**
 * @author: zhuxun
 * @data: 2019-10-18 15:46
 * @description:
 */
public class ThreadPoolBase {
    public static void main(String[] args) {

        /**
         * @author: zhuxun
         * @data: 2019-10-18 16:18
         * @description:
         * 核心线程数5
         * 最大线程数10
         * 临时线程超时10
         * 临时线程超时单位：秒
         * 等待队列，长度5，公平锁(非公平锁性能好(运气不好，一直轮不到，就饿死了)，公平锁(按顺序)防止饥饿)
         * 线程创建工厂
         * 若线程超过最大线程数，处理方法
         *
         * 若第一次，3个任务过来，创建3个线程
         * 若没完成，又来4任务，创建2线程，核心线程满，剩余2任务进入等待队列
         * 若没完成，又来4任务，3任务进入等待队列，队列满，剩余1任务，创建1个线程
         * 若没完成，又来5任务，4任务创建线程，满足最大线程数，剩余1任务，hander处理，可以打印日志，或者继续维护队列，等线程池有空，延迟做
         */
        ThreadPoolExecutor pool =  new ThreadPoolExecutor(
                5,
                10,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue(5,true),
                new MyThreadFactory(),
                new MyThreadHander()
                );

        //初始化线程池，创建所有核心线程5个
        pool.prestartAllCoreThreads();

        //初始化线程池，创建核心线程1个
        pool.prestartCoreThread();

        //核心线程在规定时间内会被回收,队列中任务为null，该线程被回收
        pool.allowCoreThreadTimeOut(true);

        /**
         * @author: zhuxun
         * @data: 2019-11-01 13:57
         * @description:    自带的创建常用线程方式，不建议使用
         * 只是使用上述的方法，制定了部分默认参数创建的线程
         */
        //指定大小
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //缓存类型，大小不限制
        executorService = Executors.newCachedThreadPool();
        //单线程化
        executorService = Executors.newSingleThreadExecutor();
        //带有生命周期的
        executorService = Executors.newScheduledThreadPool(10);
    }
}
