package designPattern;

/**
 * @author: zhuxun
 * @data: 2020-03-16 10:25
 * @description: 原型模式
 * java提供了对象clone()方法，所以在java中原型模式很简单
 * 1 抽象原型类
 * 2 具体原型类，实现抽象原型类clone()方法，可被复制
 * 3 访问类，使用具体原型类中的clone()来复制新对象
 *
 * 应用场景：
 *          1 对象之间相同或相似，直接复制，只是修改部分属性即可使用
 *          2 对象创建过程比较麻烦，复制比较简单的时候，使用
 */
public class Prototype {
}

//浅克隆
class PrototypeOne implements Cloneable{
    PrototypeOne(){
        System.out.println("具体原型创建成功");
    }

    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return super.clone();
    }

    public static void main(String[] args)throws CloneNotSupportedException
    {
        PrototypeOne obj1=new PrototypeOne();
        PrototypeOne obj2=(PrototypeOne)obj1.clone();
        System.out.println("obj1==obj2? "+(obj1==obj2));
    }
}

