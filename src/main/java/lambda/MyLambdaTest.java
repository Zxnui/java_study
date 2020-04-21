package lambda;

/**
 * Created by 123 on 2019-11-1.
 */
public class MyLambdaTest {
    public static void main(String[] args) {
        MyLambdaTestInfo demo = ()-> {
            System.out.println(1);
        };
        demo.doSomeThing();

        MyLambdaTestMoreFunc myLambdaTestMoreFunc = new MyLambdaTestMoreFunc();
        myLambdaTestMoreFunc.test(()->{
          System.out.println("second?");
        });

        myLambdaTestMoreFunc.testTwo(()->{
            System.out.println("2 second?");
        });
    }
}
