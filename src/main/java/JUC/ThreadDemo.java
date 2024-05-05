package JUC;/**
 * 作者:灰爪哇
 * 时间:2024-05-02
 */

/**
 *
 *
 * @author: Hui
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        new Thread(new WorkerThread()).start();
        new Thread(new WorkerThread()).start();
        new Thread(new WorkerThread()).start();
    }
}

class WorkerThread implements Runnable {

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() + "Thead Start ");
        System.out.println(Thread.currentThread().getName() + "Thead End.");
    }
}