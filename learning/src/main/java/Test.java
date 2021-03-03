import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 0 到 100
 *
 * @author cwp
 */
public class Test {
    private volatile AtomicInteger index = new AtomicInteger(0);
    private static final int TOTLE = 100;
    CountDownLatch countDownLatch;

    public static void main(String[] args) {
        Test test = new Test();
        test.test();

    }

    private void test() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        countDownLatch = new CountDownLatch(num);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(num, num, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024),
                r -> new Thread(r, "thread-test"), new ThreadPoolExecutor.AbortPolicy());
        for (int a = 0; a < num; a++) {
            RunTask runTask = new RunTask(a);
            threadPoolExecutor.execute(runTask);
        }
    }

    class RunTask implements Runnable {

        int num;

        public RunTask(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            synchronized (index) {
                while (index.get() < TOTLE) {
                    if (index.get() % 3 == num) {
                        System.out.println(Thread.currentThread().getName() + "|" + num + "  :  " + index.get());
                        index.incrementAndGet();
                        index.notifyAll();
                    } else {
                        try {
                            index.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}
