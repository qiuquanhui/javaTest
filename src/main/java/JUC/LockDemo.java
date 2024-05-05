package JUC;/**
 * 作者:灰爪哇
 * 时间:2024-05-05
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *
 * @author: Hui
 **/
public class LockDemo {

    public static long banlance = 10000;

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        lockDemo.lockMethod(1000);
        System.out.println("账户余额为："+banlance);
    }

    //使用lock锁的同步方法
    public void lockMethod(long money){
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        try {
            System.out.println("线程"+Thread.currentThread().getName()+"开始存款");
            banlance+=money;
        }catch (Exception e){
            System.out.println("线程"+Thread.currentThread().getName()+"存款失败");
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
