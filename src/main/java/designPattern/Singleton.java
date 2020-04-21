package designPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhuxun
 * @data: 2020-03-16 9:52
 * @description: 单例模式
 * 一个类，只有一个实例，例如打印机只能一个进程一次打印，回收站只能单次管理
 * 该单例，必须由单例类自行创建
 * 单例类对外提供一个访问该单例的全局访问点
 *
 * 常用场景：配置文件、数据库连接池，共享对象，节省内存，加快访问速度;
 *           使用非常频繁，被大量创建和销毁，多线程的线程池和网络连接池
 */
public class Singleton {

}

//懒汉模式，每次同步，会影响性能
class SingletonOne{
    //构造函数，私有化，确保无法被new
    private SingletonOne(){}

    //确保所有线程中同步
    private static volatile SingletonOne singletonOne = null;

    //通过此方法，确保单例被多进程共享使用
    public static synchronized SingletonOne getInstance(){
        if (singletonOne == null){
            singletonOne = new SingletonOne();
        }
        return singletonOne;
    }
}

//饿汉模式
class SingLetonTwo{
    //加载就创建好单例
    private static final SingLetonTwo instance=new SingLetonTwo();
    private SingLetonTwo(){}
    public static SingLetonTwo getInstance()
    {
        return instance;
    }
}

//有限多例模式
//饿汉模式，提前创建多个，client随机获取
class SingLetonThree{
    private static int n = 3;
    private static List<SingLetonThree> list = new ArrayList<>();
    private SingLetonThree(){};
    private SingLetonThree(int i){};

    static {
        for (int i = 0; i < n; i++) {
            list.add(new SingLetonThree(i));
        }
    }

    public static SingLetonThree getInstance(){
        return list.get((int) (Math.random()*n));
    }
}