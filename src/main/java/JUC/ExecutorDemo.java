package JUC;/**
 * 作者:灰爪哇
 * 时间:2024-05-05
 */

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: Hui
 **/
public class ExecutorDemo {
    public static void main(String[] args) {

        int corePoolSize = 5;
        int maximumPoolSize = 10;
        long keepAliveTime = 1000;
        TimeUnit unit = TimeUnit.SECONDS;

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingDeque<>());

        for (int i = 0; i < 10; i++){
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "正在执行");
            });
        }

        threadPoolExecutor.shutdown();

    }
}
