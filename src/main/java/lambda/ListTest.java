package lambda;

import java.util.ArrayList;
import java.util.Arrays;

public class ListTest {

    public static void main(String[] args) throws InterruptedException {
        //长度大于3的String 打印
        ArrayList<String> list = new ArrayList(Arrays.asList("111","1234","43"));
        System.out.printf("长度大于3的String:");
        list.forEach(str->{
            if (str.length()>3){
                System.out.printf(str+" ");
            }
        });
        System.out.println();

        //删除长度大于3的String
        list.removeIf(str -> str.length()>3);
        System.out.printf("删除长度大于3的String:");
        list.forEach(str -> System.out.printf(str + " "));
        System.out.println();

        //长度大于3 ，替换成大写
        ArrayList<String> list2 = new ArrayList(Arrays.asList("hhh","aaaa","cc"));
        System.out.printf("长度大于3 ，替换成大写:");
        list2.replaceAll(str->{
            if (str.length()>3){
                return str.toUpperCase();
            }
            return str;
        });
        list2.forEach(str -> System.out.printf(str + " "));
        System.out.println();

        //根据元素长度，排序
        System.out.printf("根据元素长度，排序:");
        list2.sort((str1,str2)->str1.length()-str2.length());
        list2.forEach(str-> System.out.printf(str + " "));
    }
}
