package leetcode.answer.impl.Test;

import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2021/04/06 14:18
 */
public class JVMTest implements Runnable {


     private static AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
//        TestObject testObject = new TestObject();
//        System.out.println(ClassLayout.parseInstance(testObject).toPrintable());
        JVMTest instance1 = new JVMTest();
        JVMTest instance2 = new JVMTest();
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(number);
    }

//   ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor()

    @Override
    public void run() {
        for(int i=0;i<1000000;i++){
            number.incrementAndGet();
        }
    }


}

class TestObject{
    boolean flag;
    int x;
    long x2;
    int y;
    long x1;

}
