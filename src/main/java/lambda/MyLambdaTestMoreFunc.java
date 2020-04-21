package lambda;

/**
 * Created by 123 on 2019-11-1.
 */
public class MyLambdaTestMoreFunc{

    public void test(MyLambdaTestInfo info){
        System.out.println("first?");
        info.doSomeThing();
        System.out.println("three?");
    }

    public void testTwo(MyLambdaTestInfo info){
        System.out.println("2 first?");
        info.doSomeThing();
        System.out.println("2 three?");
    }
}
