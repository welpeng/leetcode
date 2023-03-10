import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cwp
 * @date 2022-09-28 11:32
 */
public class PrintABC {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        Thread a = new Thread(new PrintfABCThread("A", lock, 0));
        Thread b = new Thread(new PrintfABCThread("B", lock, 1));
        Thread c = new Thread(new PrintfABCThread("C", lock, 2));

        a.start();
        b.start();
        c.start();
    }
}

class PrintfABCThread implements Runnable {
    private String name;
    private Lock lock;
    private Integer flag;

    public static int count = 0;

    public static final int MAX = 30;

    public PrintfABCThread(String name, Lock lock, Integer flag) {
        this.name = name;
        this.lock = lock;
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();

            if (count >= MAX) {
                lock.unlock();
                return;
            }

            if (count % 3 == flag) {
                System.out.println(name);
                count++;
            }
            lock.unlock();
        }
    }
}

