package lesson_3;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ThreadSafeCounter {

    private final Lock lock = new ReentrantLock();
    private int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        ThreadSafeCounter counter = new ThreadSafeCounter();

        for (int i = 0; i < 10; i++) {
            Thread threadIncrement = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    counter.increment();
                }
            });
            threadIncrement.start();
        }
        Thread.sleep(500);
        System.out.println(counter.getCounter());

        for (int i = 0; i < 10; i++) {
            Thread threadDecrement = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    counter.decrement();
                }
            });
            threadDecrement.start();
        }
        Thread.sleep(500);
        System.out.println(counter.getCounter());
    }

    public void increment() {
        try {
            lock.lock();
            counter++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        try {
            lock.lock();
            counter--;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }
}

