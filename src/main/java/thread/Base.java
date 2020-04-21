package thread;

/**
 * @author: zhuxun
 * @data: 2019-11-01 13:50
 * @description:
 * 开始 start
 * 状态 就绪
 * 系统调度，cpu分配资源
 * 执行run()
 * 运行中，可能阻塞，线程阻塞让出cpu资源，进入状态：就绪
 * run执行完成后，死亡，可调用stop和destory强制终止
 */
public class Base {
    //并行，两个任务同时进行，左手喝水，右手鼠标，多核cpu支撑
    //并发，两个任务同时进行，处理器只能处理一个，安排轮流执行，感觉在同时进行
    public static void main(String[] args) {
        Runnable runnable = () ->{
            for (int i = 0; i < 3; i++) {
                System.out.println("子线程one:"+ i +" 线程id："+Thread.currentThread().getId());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnable).start();

        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                System.out.println("子线程two:"+ i +"线程name："+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("主线程");
    }

}
