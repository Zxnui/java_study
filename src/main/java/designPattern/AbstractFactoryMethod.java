package designPattern;

/**
 * @author: zhuxun
 * @data: 2020-03-18 16:25
 * @description: 抽象工厂模式
 * 和工厂模式区别，可生产多类别多等级产品
 * 抽象工厂
 * 具体工厂
 * 抽象产品
 * 具体产品
 */
public class AbstractFactoryMethod {
    public static void main(String[] args) {
        AbstractFactory factory = new AFactoryImpl1();
        factory.newProduct1().show();
        factory.newProduct2().show();

        /**
         * 同一个工厂可以生产多个产品，工厂模式是一个工厂对应一个产品
         * 但是增加新产品时，需要修改所有工厂，才能让所有的工厂都能生产这个新产品
         * 当产品只有1个的时候，此时抽象工厂就退化为工厂模式
         *
         * 一般来说，小米手机，小米电脑
         *           华为手机，华为电脑
         *           此处可以组织两个工厂，一个工厂生产小米产品(手机，电脑)
         *           一个工厂生产华为产品(手机，电脑)
         *           或者都生产手机，都生产电脑
         *
         *           所以，该模式应用场景：
         *           1 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。
         *           2 系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。
         *           3 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。
         */
    }
}

interface AProduct{
    void show();
}

class AProductImpl1 implements AProduct{
    public void show(){
        System.out.println("产品1");
    }
}

class AProductImpl2 implements AProduct{
    public void show(){
        System.out.println("产品2");
    }
}

interface AbstractFactory {
    AProductImpl1 newProduct1();
    AProductImpl2 newProduct2();
}

class AFactoryImpl1 implements AbstractFactory {

    @Override
    public AProductImpl1 newProduct1() {
        System.out.println("工厂1 生产");
        return new AProductImpl1();
    }

    @Override
    public AProductImpl2 newProduct2() {
        System.out.println("工厂1 生产");
        return new AProductImpl2();
    }
}

