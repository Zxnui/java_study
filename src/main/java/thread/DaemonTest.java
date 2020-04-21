package thread;

/**
 * @author: zhuxun
 * @data: 2019-11-01 15:05
 * @description: 守护线程，在其他线程结束后，才结束
 */
public class DaemonTest {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            while (true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("守护线程");
            }
        });

        thread.setDaemon(true);

        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("非守护进程"+i);
            }
        }).start();

        thread.start();
    }
}
