package designPattern;
/**
 * @author: zhuxun
 * @data: 2020-03-16 10:43
 * @description: 工厂方法
 * 抽象工厂
 * 具体工厂
 * 抽象产品
 * 具体产品
 * 生产同类，或者同等级产品
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Factory f1 = new FactoryImpl1();
        Factory f2 = new FactoryImpl2();
        f1.newProduct().show();
        f2.newProduct().show();

        //后续，只需要增加对应的新的Factory实现和Product实现，不需要修改之前的任何代码，即能完成拓展。满足开闭原则
        //可根据需要，接入xml实现，配置新工厂，增加读取解析xml代码，获取新的工厂实现和产品实现。
    }
}

interface Product{
    void show();
}

class ProductImpl1 implements Product{
    public void show(){
        System.out.println("产品1");
    }
}

class ProductImpl2 implements Product{
    public void show(){
        System.out.println("产品2");
    }
}

interface Factory{
    Product newProduct();
}

class FactoryImpl1 implements Factory{
    public Product newProduct(){
        System.out.println("工厂1开始生产");
        return new ProductImpl1();
    }
}

class FactoryImpl2 implements Factory{
    public Product newProduct(){
        System.out.println("工厂2开始生产");
        return new ProductImpl2();
    }
}
