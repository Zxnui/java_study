package lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: zhuxun
 * @data: 2019-10-18 9:57
 * @description:
 * 无存储            stream不是一种数据结构，它只是某种数据源的一个视图，数据源可以是一个数组，Java容器或I/O channel等。
 * 为函数式编程而生  对stream的任何修改都不会修改背后的数据源，比如对stream执行过滤操作并不会删除被过滤的元素，而是会产生一个不包含被过滤元素的新stream。
 * 惰式执行          stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
 * 可消费性          stream只能被“消费”一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。
 *
 * String::length;如果Lambda表达式的全部内容就是调用一个已有的方法，那么可以用方法引用来替代Lambda表达式。
 * 参考链接：https://objcoding.com/2019/03/04/lambda/
 */
public class StreamsTest {

    public static void main(String[] args) {
        //遍历
        Stream<String> stream =Stream.of("1","2","3","4");
        stream.forEach(str->System.out.println(str));
        System.out.println("-------------------------------");

        //条件中间操作
        Stream<String> stream2 =Stream.of("1","2","3","4");
        stream2.filter(str-> str.equals("3"))
                .forEach(str->System.out.println(str));
        System.out.println("-------------------------------");

        //去重
        Stream<String> stream3= Stream.of("1", "2", "3", "4", "4");
        stream3.distinct()
                .forEach(str -> System.out.println(str));
        System.out.println("-------------------------------");

        //排序，正向
        Stream<String> stream4= Stream.of("1", "2", "4", "3");
        stream4.sorted(Comparator.reverseOrder())
                .forEach(str -> System.out.println(str));
        System.out.println("-------------------------------");
        //排序，倒叙
        stream4= Stream.of("1", "2", "4", "3");
        stream4.sorted()
                .forEach(str -> System.out.println(str));
        System.out.println("-------------------------------");

        //map 对元素处理后，返回
        Stream<String> stream5 = Stream.of("zhu", "xun");
        stream5.map(str -> str.toUpperCase())
                .forEach(str -> System.out.println(str));
        System.out.println("-------------------------------");

        //flatMap 所有元素取出，处理，返回，例如stream中是2个list,长度分别为2和3，最后返回一个steam 长度5
        Stream<List<Integer>> stream6 = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
        stream6.flatMap(list -> list.stream())
                .forEach(i -> System.out.println(i));
        System.out.println("-------------------------------");

        //reduce操作可以实现从一组元素中生成一个值，sum()、max()、min()、count()等都是reduce操作
        // 找出最长的单词
        Stream<String> stream7 = Stream.of("chen", "bo", "yu", "2B");
        Optional<String> longest = stream7.reduce((s1, s2) -> s1.length()>=s2.length() ? s1 : s2);
        System.out.println(longest.get());
        System.out.println("-------------------------------");
        // 求单词长度之和
        Stream<String> stream8 = Stream.of("chen", "bo", "yu", "2B");
        Integer lengthSum = stream8.reduce(0,
                        (sum, str) ->
                        sum+str.length(), (a, b) -> a+b);
        System.out.println(lengthSum);
        System.out.println("-------------------------------");

        //collect，一系列操作，返回多数据
        // 将Stream转换成list,set,map
        Stream<String> stream9 = Stream.of("chen", "bo", "yu", "2B");
        List<String> list = stream9.collect(Collectors.toList());

        //另一种转化list方法，new规定了目标容器，add如何添加到容器，addAll多个结果如何合并添加到容器中
        //List<String> list = stream9.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        //可以指定新容器类型
        //ArrayList<String> arrayList = stream9.collect(Collectors.toCollection(ArrayList::new));

        // Set<String> set = stream9.collect(Collectors.toSet());
        //可以指定新容器类型
        //HashSet<String> set = stream9.collect(Collectors.toCollection(HashSet::new));

        //Function.identity();接口中的静态方法，作用返回一个输出跟输入一样的Lambda表达式对象，等价于形如t -> t形式的Lambda表达式。
        //        Map<String, Integer> map = stream9.collect(Collectors.toMap(
        //                Function.identity(),//map的key
        //                String::length)//map的value
        //        );

        class Student{
            String name;
            int num;
            int age;

            public Student(String name, int num,int age) {
                this.name = name;
                this.num = num;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }

        //partitioningBy()生成的收集器，这种情况适用于将Stream中的元素依据某个二值逻辑（满足条件，或不满足）分成互补相交的两部分
        //分数及格和不及格分类
        List<Student> students = Arrays.asList(
                new Student("zhuxun",100,30),
                new Student("chenboyu1",55,25),
                new Student("chenboyu2",60,25));
        Map<Boolean,List<Student>> studentToGPA = students.stream().collect(Collectors.partitioningBy(s-> s.getNum() >= 60));
        System.out.println("及格人：");
        studentToGPA.get(true).stream().forEach(s-> System.out.println(s.getName() + "=" + s.getNum()));
        System.out.println("不及格人：");
        studentToGPA.get(false).stream().forEach(s-> System.out.println(s.getName() + "=" + s.getNum()));
        System.out.println("-------------------------------");

        //groupingBy()生成的收集器，这是比较灵活的一种情况。跟SQL中的group by语句类似
        //根据年龄分类
        Map<Integer,List<Student>> studentAge = students.stream()
                .collect(
                        Collectors.groupingBy(Student::getAge)
                );
        System.out.println("30岁：");
        studentAge.get(30).stream().forEach(s-> System.out.println(s.getName() + "=" + s.getAge()));
        System.out.println("25岁：");
        studentAge.get(25).stream().forEach(s-> System.out.println(s.getName() + "=" + s.getAge()));
        System.out.println("-------------------------------");
        //根据年龄统计人数
        Map<Integer,Long> studentAgeNum = students.stream()
                .collect(
                        Collectors.groupingBy(Student::getAge,
                                Collectors.counting())
                );
        System.out.println("30岁：");
        System.out.println(studentAgeNum.get(30));
        System.out.println("25岁：");
        System.out.println(studentAgeNum.get(25));
        System.out.println("-------------------------------");
        //根据年龄统计名字list
        Map<Integer,List<String>> studentAgeName = students.stream()
                .collect(Collectors.groupingBy(Student::getAge,
                Collectors.mapping(Student::getName,
                        Collectors.toList()
                        )
                ));
        System.out.println("30岁：");
        studentAgeName.get(30).forEach(s-> System.out.println(s));
        System.out.println("25岁：");
        studentAgeName.get(25).forEach(s-> System.out.println(s));
        System.out.println("-------------------------------");

        //字符串拼接
        Stream<String> stream10 = Stream.of("zhu","xun");
        String name = stream10.collect(Collectors.joining());
        stream10 = Stream.of("zhu","xun");//被消费，重新构建
        String name2 = stream10.collect(Collectors.joining(","));
        stream10 = Stream.of("zhu","xun");//被消费，重新构建
        String name3 = stream10.collect(Collectors.joining(",", "{", "}"));
        System.out.println("name = "+name+"<--->name2 = "+name2+ "<--->name3"+name3);
    }
}
