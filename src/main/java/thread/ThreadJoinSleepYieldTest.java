package thread;

/**
 * @author: zhuxun
 * @data: 2019-11-01 14:54
 * @description:
 */
public class ThreadJoinSleepYieldTest {
    public static void main(String[] args) throws Exception {
        new Thread(()->{
            System.out.println(1);
        }).start();

        Thread thread = new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println(2+"start");
                Thread.sleep(1000);
                System.out.println(2+"end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        //join ，3必须等2完成再执行
        //无join,2start 2end最后输出
        thread.join();

        new Thread(()->{
            System.out.println(3);
        }).start();

//        Thread.yield();
        //线程立马进入Runnable(就绪状态)
        // 不同于sleep()和join（）方法，因为这两个方法是使线程进入阻塞状态
        // 除此之外，yield()方法还与线程优先级有关，当某个线程调用yield()方法时，就会从运行状态转换到就绪状态后
        // CPU从就绪状态线程队列中只会选择与该线程优先级相同或者更高优先级的线程去执行。

    }
}
