package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhuxun
 * @data: 2019-11-04 10:45
 * @description:
 * lockInterruptibly()获得锁，但有限响应中断
 * 线程通过lockInterruptibly获取锁，一旦有其他线程调用了该线程的interrupt，则该线程就会抛出InterruptedException异常，被中断的线程，需要去处理该异常。
 */
public class ReentrantLockInterruptiblyTest {
    private static int num = 0;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Runnable runnable = ()->{
            while (true) {
                try {
                    reentrantLock.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName()+"获取锁,num="+num);
                    Thread.sleep(2000);
                    num++;
                    System.out.println(Thread.currentThread().getName()+"获取锁，2秒后,num="+num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()+"锁被中断");
                } finally {
                    System.out.println(Thread.currentThread().getName()+"释放锁");
                    reentrantLock.unlock();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        new Thread(()->{
            while (true){
                try {
                    System.out.println("让前一个线程中断");
                    thread.interrupt();
                    if(reentrantLock.tryLock(1,TimeUnit.SECONDS)){
                        try {
                            System.out.println(Thread.currentThread().getName()+"获取锁,num="+num);
                            Thread.sleep(2000);
                            num=num+10;
                            System.out.println(Thread.currentThread().getName()+"获取锁，2秒后,num="+num);
                        }catch (Exception e){
                            e.printStackTrace();
                            System.out.println(Thread.currentThread().getName()+"获取锁失败");
                        }finally {
                            reentrantLock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName()+"没有获取到锁");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
