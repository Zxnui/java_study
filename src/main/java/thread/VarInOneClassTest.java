package thread;

/**
 * @author: zhuxun
 * @data: 2019-11-01 15:40
 * @description:
 */
public class VarInOneClassTest {
    public static void main(String[] args) {
        Test test = new Test();

        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
    }
}

class Test implements Runnable{
    private int num = 5;

    @Override
    public void run() {
        while (true){
            if (this.num>0){
                System.out.println("num is : "+num--);
            }else {
                System.out.println("end");
                break;
            }
        }
    }
}