package thread;

/**
 * @author: zhuxun
 * @data: 2019-11-01 16:00
 * @description:
 * 数字和小字母必然不可能多线程混杂
 * 大字母多线程混杂打印
 * SynTest在不同线程被使用时，print1 和print2互斥
 * 但若是SynTest t1 ,一个线程调用t.print1,另一个线程可以调用t1.print1
 *
 * synchronized 静态方法的话，就是锁类
 * synchronized 非静态方法的话，就是锁对象
 */
public class SynchronizedMethodTest {
    public static void main(String[] args) {
        SynTest t = new SynTest();

        Runnable runnable = ()->{
            for (int i = 0; i <3 ; i++) {
                t.print1(Thread.currentThread().getName());
                t.print2(Thread.currentThread().getName());
                t.print3(Thread.currentThread().getName());
            }
        };

        for (int i = 0; i <3 ; i++) {
            new Thread(runnable).start();
        }

    }
}

class SynTest{
    //必然一起
    public synchronized void print1(String name){
        System.out.print(" 111"+name);
        System.out.print(" 222"+name);
        System.out.print(" 333"+name);
        System.out.print(" 444"+name);
        System.out.println();
    }
    //必然一起
    public void print2(String name){
        synchronized (this){
            System.out.print(" aaaaa"+name);
            System.out.print(" bbbbb"+name);
            System.out.print(" ccccc"+name);
            System.out.print(" ddddd"+name);
            System.out.println();
        }
    }

    public void print3(String name){
        System.out.print(" AAAAAAAAA"+name);
        System.out.print(" BBBBBBBBB"+name);
        System.out.print(" CCCCCCCCC"+name);
        System.out.print(" DDDDDDDDD"+name);
        System.out.println();
    }
}
