package list;/**
 * 作者:灰爪哇
 * 时间:2023-12-20
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 *
 * @author: qiuqiu
 **/
public class ListTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("hello");
        list.add("world");
        list.add("qiuqiu");

        long currentTimeMillis = System.currentTimeMillis();
        //1.增强for
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
        //2.迭代器
        currentTimeMillis = System.currentTimeMillis();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        //3.toArray(),转换为数组
        currentTimeMillis = System.currentTimeMillis();
        Object[] array = list.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("Test");
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        //4.get方法
        currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }
}
