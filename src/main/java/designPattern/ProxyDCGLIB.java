package designPattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: zhuxun
 * @data: 2020-03-13 16:54
 * @description: CGLIB动态代理
 * java动态代理，必须对实现接口的类进行代理，若不能实现接口的类，就不能代理，例如例子中的subd实现
 * cglib 对类来代理，对指定目标类生成子类，覆盖其中的方法，实现增强。采用的是继承，所以不能对final修饰的类进行代理
 */
interface SubDC{
    void test();
}

class SubDCImpl implements SubDC{
    public void test(){
        System.out.println("运行中...");
    }
}

public class ProxyDCGLIB implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o,objects);
        after();
        return result;
    }

    private void before(){
        System.out.println("运行前...动态代理");
    }

    private void after(){
        System.out.println("后运行...动态代理");
    }

    //运行测试
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();//无接口的创建代理，可以根据给定的类，创建子类，并且所有非final的方法都带有回调钩子
        enhancer.setSuperclass(SubDCImpl.class);//继承被代理的类
        enhancer.setCallback(new ProxyDCGLIB());//设置回调，具体调用ProxyDCGLIB中，methodProxy调用。这个本质上是Callback-MethodInterceptor方法拦截器

        SubDC subDC = (SubDC) enhancer.create();//生成代理对象
        subDC.test();
    }
}
