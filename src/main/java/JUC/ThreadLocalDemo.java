package JUC;/**
 * 作者:灰爪哇
 * 时间:2024-05-03
 */

/**
 *
 *
 * @author: Hui
 **/
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("123");
        threadLocal.set("456");
        System.out.println(threadLocal.get());
        threadLocal.remove();
    }
}
