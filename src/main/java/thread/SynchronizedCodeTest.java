package thread;

/**
 * @author: zhuxun
 * @data: 2019-11-01 16:31
 * @description:
 * byte 充当锁
 */
public class SynchronizedCodeTest {

    private static int numSyn = 0;
    private static int numOne = 0;

    public static void main(String[] args) {
        Runnable runnable = ()->{
            byte[] test = new byte[0];
            synchronized (test){
                numSyn++;
            }
            numOne++;
            System.out.println("numSyn="+numSyn);
            System.out.println("numOne="+numOne);
        };

        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }
    }
}
