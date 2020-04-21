package lambda;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapTest {

    public static void main(String[] args) {

        //遍历打印
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.forEach((k,v)-> System.out.println(k + "=" + v));
        System.out.println();

        //不存在key 打印noValue
        System.out.println(map.getOrDefault(4,"noValue"));
        System.out.println();

        //小写换大写
        map.replaceAll((k, v) -> v.toUpperCase());
        map.forEach((k,v)-> System.out.println(k + "=" + v));
        System.out.println();

        //信息拼接
        map.merge(1, "test", (v1, v2) -> v1+v2);
        map.forEach((k,v)-> System.out.println(k + "=" + v));
        System.out.println();

        //computeIfAbsent
        //该方法签名为V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)，
        // 作用是：只有在当前Map中不存在key值的映射或映射值为null时，才调用mappingFunction，并在mappingFunction执行结果非null时，将结果跟key关联．
        Map<Integer, Set<String>> map2 = new HashMap<>();
        // Java7及以前的实现方式
        if(map2.containsKey(1)){
            map2.get(1).add("one");
        }else{
            Set<String> valueSet = new HashSet<String>();
            valueSet.add("one");
            map2.put(1, valueSet);
        }
        // Lambda的实现方式
        map2.computeIfAbsent(1, v -> new HashSet<String>()).add("yi");


        //computeIfPresent
        //该方法签名为V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)，
        // 作用跟computeIfAbsent()相反，即，只有在当前Map中存在key值的映射且非null时，才调用remappingFunction，
        // 如果remappingFunction执行结果为null，则删除key的映射，否则使用该结果替换key原来的映射
    }
}
