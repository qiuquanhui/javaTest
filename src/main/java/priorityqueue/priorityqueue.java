package priorityqueue;/**
 * 作者:灰爪哇
 * 时间:2023-12-18
 */

import javafx.util.Pair;

import java.util.PriorityQueue;

/**
 *
 *
 * @author: qiuqiu
 **/
public class priorityqueue {
    public static void main(String[] args) {

        PriorityQueue<Pair<user, Long>> pairs = new PriorityQueue<Pair<user, Long>>(5);

        user user = new user();
        user user2 = new user();
        user user3 = new user();
        user user4 = new user();
        user user5 = new user();


        pairs.add(new Pair<user, Long>(user,1l));
//        pairs.add(new Pair<user, Long>(user,2l));
//        pairs.add(new Pair<user, Long>(user,3l));
//        pairs.add(new Pair<user, Long>(user,4l));
//        pairs.add(new Pair<user, Long>(user,5l));
//        pairs.add(new Pair<user, Long>(user,6l));

        System.out.println(pairs.size());
        System.out.println(pairs.poll());

    }
}
