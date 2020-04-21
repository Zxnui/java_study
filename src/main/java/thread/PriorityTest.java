package thread;

/**
 * @author: zhuxun
 * @data: 2019-11-01 15:14
 * @description:
 * priority 1-10 之间，10最高
 */
public class PriorityTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(1111);
            }
        });

        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(2222);
            }
        });

        Thread thread3 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(3333);
            }
        });

        thread1.setPriority(1);
        thread2.setPriority(1);
        thread3.setPriority(10);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
