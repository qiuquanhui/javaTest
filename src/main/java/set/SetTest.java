package set;/**
 * 作者:灰爪哇
 * 时间:2023-12-20
 */

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 *
 * @author: qiuqiu
 **/
public class SetTest {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("hello");
        set.add("world");
        set.add("qiuqiu");

        long currentTimeMillis = System.currentTimeMillis();
        //1.增强for
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
        //2.迭代器
        currentTimeMillis = System.currentTimeMillis();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        //3.toArray(),转换为数组
        currentTimeMillis = System.currentTimeMillis();
        Object[] array = set.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        //4.stream;流
        currentTimeMillis = System.currentTimeMillis();
       set.forEach(s -> {
           System.out.println(s);
       });
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }
}
