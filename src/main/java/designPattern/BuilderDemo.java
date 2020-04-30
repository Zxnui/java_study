package designPattern;

/**
 * @author: zhuxun
 * @data: 2020-03-18 16:58
 * @description: 建造模式
 * 优点：各个建造细节独立，客户端无需内部细节
 * 缺点：产品组成部分相同，内部变化复杂，配套建造类会很复杂
 * 建造模式：重视组装，工厂模式：重视创建过程
 */
public class BuilderDemo {

    public static void main(String[] args) {
        AbstractBuilder builder = new SimpleBuilder();
        Director director = new Director(builder);
        ProductBuild product = director.construct();
        product.show();
    }
}

class ProductBuild{
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show(){
        System.out.println("完成组装，产品展示 - ABC");
    }
}

abstract class AbstractBuilder{
    protected ProductBuild product = new ProductBuild();
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    public ProductBuild getResult(){
        return product;
    }
}

class SimpleBuilder extends AbstractBuilder {

    @Override
    public void buildPartA() {
        System.out.println("建造A");
    }

    @Override
    public void buildPartB() {
        System.out.println("建造B");
    }

    @Override
    public void buildPartC() {
        System.out.println("建造C");
    }
}

class Director{
    private AbstractBuilder builder;
    public Director(AbstractBuilder builder){
        this.builder = builder;
    }

    public ProductBuild construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();

        return builder.getResult();
    }
}
