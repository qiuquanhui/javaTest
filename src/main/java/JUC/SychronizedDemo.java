package JUC;/**
 * 作者:灰爪哇
 * 时间:2024-05-05
 */

/**
 *
 *
 * @author: Hui
 **/
public class SychronizedDemo {
    public static void main(String[] args) {
        SychronizedDemo sychronizedDemo = new SychronizedDemo();
        sychronizedDemo.deposit(1000);
        sychronizedDemo.syncmethod();
    }

    //同步方法
    public synchronized void syncmethod(){
        System.out.println(Thread.currentThread().getName() + " 执行同步方法 ");
    }

    //同步代码快
    public void deposit(long money){
        long balance = 1000;

        synchronized (this){
           try {
               Thread.sleep(1000);
           }catch (Exception e){
               System.out.println("同步答辩");
               e.printStackTrace();
           }
        }
        balance+=money;
        System.out.println(Thread.currentThread().getName()+"存钱成功，余额为"+balance);
    }
}
