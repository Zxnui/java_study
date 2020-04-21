package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhuxun
 * @data: 2019-11-04 16:00
 * @description:
 */
public class ConditionTest {

    private static ReentrantLock lock = new ReentrantLock();

    public static void await(Condition condition) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "进入了waitA方法");
            long timeBefore = System.currentTimeMillis();
            // 执行conditionA等待
            condition.await();
            long timeAfter = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"被唤醒");
            System.out.println(Thread.currentThread().getName() + "等待了: " + (timeAfter - timeBefore)/1000+"s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void signAll(Condition condition){
        try {
            lock.lock();
            System.out.println("启动唤醒");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(()->{
           await(condition1);
        }).start();

        new Thread(()->{
            await(condition2);
        }).start();

        try {
            Thread.sleep(3000);
            signAll(condition1);
            Thread.sleep(3000);
            signAll(condition2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
