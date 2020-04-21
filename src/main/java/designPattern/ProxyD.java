package designPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zhuxun
 * @data: 2020-03-13 16:22
 * @description: 动态代理
 */
interface SubD{
    void test();
}

class SubDImpl implements SubD {
    public void test() {
        System.out.println("动态代理真正被运行...");
    }
}

public class ProxyD implements InvocationHandler {
    private SubD subD;

    public ProxyD(SubD subD){
        this.subD = subD;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),subD.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(subD,args);
        after();
        return object;
    }

    private void before(){
        System.out.println("运行前...动态代理");
    }

    private void after(){
        System.out.println("后运行...动态代理");
    }

    //主运行函数
    //java的动态代理，只能代理接口
    public static void main(String[] args) {
        SubDImpl subD = new SubDImpl();

        //此处，动态代理可以对所有实现subD接口所有类进行代理，只要传入实现SubD接口的实例即可
        //不需要提前知道入参，被代理的时候什么，运行时候才知道，静态不行
        ProxyD proxyD = new ProxyD(subD);

        //动态代理proxy class类通过反射生成，静态代理，必须提前生成
        SubD proxy = (SubD)proxyD.getProxy();
        proxy.test();
    }

}

