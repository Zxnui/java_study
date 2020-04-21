package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhuxun
 * @data: 2019-11-04 10:45
 * @description:
 * ReentrantLock(boolean fair) 默认false，非公平锁
 * lock()
 * unlock()
 * tryLock()
 * tryLock(long time,TimeUnit unit)
 * lockInterruptibly()获得锁，但有限响应中断
 * 可以重复获取锁，锁需要去识别获取锁的线程是否为当前占据锁的线程，如果是，则再次成功获取。
 */
public class ReentrantLockTest {
    private static int num = 0;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Runnable runnable = ()->{
            while (true) {
                try {
                    //2秒获取锁时间,获取到返回true，获取不到，返回false
                    if (reentrantLock.tryLock(2, TimeUnit.SECONDS)) {
                        try {
                            num++;
                            System.out.println(Thread.currentThread().getName()+"获取到第一次锁，num:" + num );
                            Thread.sleep(2000);
                            try {
                                reentrantLock.lock();
                                num++;
                                System.out.println(Thread.currentThread().getName()+"第二次获取到了锁，num:" + num );
                                Thread.sleep(2000);
                            }finally {
                                reentrantLock.unlock();
                                System.out.println(Thread.currentThread().getName()+"释放第二次锁");
                            }

                        }finally {
                            System.out.println(Thread.currentThread().getName()+"释放第一次锁");
                            reentrantLock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName()+"被锁住，无法获取锁");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()+"无法获取锁，2秒超时已到");
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
