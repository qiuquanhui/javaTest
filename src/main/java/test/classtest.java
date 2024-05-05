package test;/**
 * 作者:灰爪哇
 * 时间:2024-03-13
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 * @author: Hui
 **/
public class classtest {
    public static void main(String[] args) {
        String completeName =
                "曹彤\n" +
                "陈华雄\n" +
                "陈星达\n" +
                "陈宇\n" +
                "陈睿林\n" +
                "程方文\n" +
                "程宇豪\n" +
                "冯焕恺\n" +
                "顾嘉帆\n" +
                "黄海彬\n" +
                "黄华鸿\n" +
                "黄维斯\n" +
                "江梓豪\n" +
                "李丹婷\n" +
                "李楹杰\n" +
                "梁舒琪\n" +
                "林健斌\n" +
                "林文潮\n" +
                "刘祖怡\n" +
                "卢俊\n" +
                "罗锡灿\n" +
                "麦佳深\n" +
                "欧俊其\n" +
                "王誉达\n" +
                "王湛\n" +
                "肖誉\n" +
                "严家乐\n" +
                "严思婷\n" +
                "严瀚\n" +
                "严梓圣\n" +
                "杨礼泽\n" +
                "杨鹏\n" +
                "张广源\n" +
                "张浩\n" +
                "张鑫鹏\n" +
                "钟佳宏\n" +
                "周靖怡\n" +
                "葛嘉升\n" +
                "赖康杰\n" +
                "潘水清\n" +
                "陈星达\n" +
                "陈宇\n" +
                "陈睿林\n" +
                "程方文\n" +
                "程宇豪\n" +
                "冯焕恺\n" +
                "顾嘉帆\n" +
                "黄海彬\n" +
                "黄华鸿\n" +
                "黄维斯\n" +
                "江梓豪\n" +
                "李丹婷\n" +
                "李楹杰\n" +
                "梁舒琪\n" +
                "林健斌\n" +
                "林文潮\n" +
                "刘祖怡\n" +
                "卢俊\n" +
                "罗锡灿\n" +
                "麦佳深\n" +
                "欧俊其\n" +
                "王誉达\n" +
                "王湛\n" +
                "肖誉\n" +
                "严家乐\n" +
                "严思婷\n" +
                "严瀚\n" +
                "严梓圣\n" +
                "杨礼泽\n" +
                "杨鹏\n" +
                "张广源\n" +
                "张浩\n" +
                "张鑫鹏\n" +
                "钟佳宏\n" +
                "周靖怡\n" +
                "朱俊熹\n" +
                "赖康杰\n" +
                "潘水清\n" +
                "李伟\n" +
                "鞠金宏\n"+
                "邱权辉\n"+
                "陈泓霓\n" ;;

        String[] names = completeName.split("\n");

        int numberOfNames = names.length;

        System.out.println("Number of names: " + numberOfNames);

        // 将名字数组转换为Set集合，去除重复的名字
        Set<String> uniqueNamesSet = new HashSet<>(Arrays.asList(names));

        // 将Set集合转换为字符串数组
        String[] uniqueNames = uniqueNamesSet.toArray(new String[0]);

        System.out.println("Number of unique names: " + uniqueNames.length);

        String lackName = "张浩\n" +
                "欧俊其\n" +
                "严瀚\n" +
                "陈泓霓\n" +
                "黄海彬\n" +
                "周靖怡\n" +
                "陈睿林\n" +
                "陈宇\n" +
                "杨礼泽\n" +
                "潘水清\n" +
                "王誉达\n" +
                "卢俊\n" +
                "程宇豪\n" +
                "张广源\n" +
                "梁舒琪\n" +
                "亚梓圣\n" +
                "冯焕恺\n" +
                "杨鹏\n" +
                "李伟\n" +
                "鞠金宏\n" +
                "黄维斯\n" +
                "陈华雄\n" +
                "罗锡灿\n" +
                "陈星达\n" +
                "麦佳深\n" +
                "曹彤\n" +
                "程方文\n" +
                "黄华鸿\n" +
                "程宇豪\n" +
                "李丹婷\n" +
                "林健斌\n" +
                "赖康杰\n" +
                "王湛\n" +
                "严家乐\n" +
                "邱权辉\n" +
                "肖誉\n" +
                "李楹杰\n" +
                "钟佳宏\n" +
                "林文潮\n" +
                "江梓豪";
        
        String[] lackNames = lackName.split("\n");
        
        //对比唯一跟缺乏名字哪些是两个都没有的
        HashSet<String> lackNamesSet = new HashSet<>(Arrays.asList(lackNames));

        uniqueNamesSet.removeAll(lackNamesSet);
        System.out.println(uniqueNamesSet);
    }
}
