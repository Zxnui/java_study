package thread;

import java.util.concurrent.Semaphore;

/**
 * @author: zhuxun
 * @data: 2020-04-21 11:08
 * @description:
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        for (int j = 0; j < 3; j++) {
            new Thread(()->{
                //多线程，同时只能有2个线程操作某个事情
                try {
                    semaphore.acquire();
                    Thread.sleep(2000);
                    System.out.println(111);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
