package string;/**
 * 作者:灰爪哇
 * 时间:2024-03-21
 */

/**
 *
 *
 * @author: Hui
 **/
public class SplitTest {

    public static void main(String[] args) {
        String str = "1,2,3,4,5,6,7,8,9";
        String value = str.split(",")[1].split("2")[0];

//        String value = key2.split("\\u001Fa")[1].split("\\u001F")[0];
        System.out.println(value);
    }
}
