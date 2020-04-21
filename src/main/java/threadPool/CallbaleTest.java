package threadPool;

import java.util.concurrent.*;

/**
 * @author: zhuxun
 * @data: 2019-11-01 14:37
 * @description: 获取线程返回值
 */
public class CallbaleTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Callable<Integer> callable = ()->{
            System.out.println("子线程在进行计算");
            Thread.sleep(2000);
            int sum = 0;
            for(int i=0;i<10;i++)
                sum += i;
            return sum;
        };


        //executorService.submit()和execute()区别,参数和返回值都不一样
        executorService.execute(new Thread(()->{
            System.out.println("子线程执行execute");
        }));
        //获取返回值
        Future<Integer> result = executorService.submit(callable);
        //通过FutureTase获取
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        executorService.submit(futureTask);
        executorService.shutdown();

        System.out.println("主线程执行中");
        try {
            System.out.println("Future获取返回值："+result.get());
            System.out.println("FutureTask获取返回值："+futureTask.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("全部执行完成");
    }
}
