package designPattern;

/**
 * @author: zhuxun
 * @data: 2020-03-13 16:14
 * @description: 静态代理
 * 在不影响sub和subimpl 的情况下，通过MyProxy来对test的方法进行优化。解耦很好
 */
interface Sub{
    void test();
}

class SubImpl implements Sub {
    public void test(){
        System.out.println("真正被运行...");
    }
}

public class Proxy {
    public static void main(String[] args) {
        MyProxy proxy = new MyProxy();
        proxy.test();
    }
}

class MyProxy implements Sub{
    private SubImpl subImpl;

    public void test(){
        if (subImpl ==null){
            subImpl = new SubImpl();
        }
        before();
        subImpl.test();
        after();
    }

    private void before(){
        System.out.println("运行前...");
    }

    private void after(){
        System.out.println("后运行...");
    }
}