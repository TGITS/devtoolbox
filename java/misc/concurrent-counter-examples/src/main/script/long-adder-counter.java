/// usr/bin/env jbang "$0" "$@" ; exit $?
// A exécuter avec JBang : jbang long-adder-counter.java

import java.time.Duration;
import java.util.concurrent.atomic.LongAdder;

interface LongCounter {
    String name();

    void increment();

    long value();
}

class LongAdderCounter implements LongCounter {

    private final LongAdder counter;
    private final String name;

    public LongAdderCounter(String name) {
        this.counter = new LongAdder();
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void increment() {
        this.counter.increment();
    }

    @Override
    public long value() {
        return counter.sum();
    }
}

class IncrementerWorker implements Runnable {

    private final LongCounter counter;

    public IncrementerWorker(LongCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            counter.increment();
            try {
                Thread.sleep(Duration.ofMillis(10));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}

class Main {

    public static void main(String... args) throws InterruptedException {
        System.out.println("Code examples with updated counter in concurrent environment");
        LongCounter longAdderCounter = new LongAdderCounter("AtomicLongCounter");
        updateCounterFromThreads(longAdderCounter);
    }

    public static void updateCounterFromThreads(LongCounter longCounter) throws InterruptedException {
        System.out.println(longCounter.name() + " initial value : " + longCounter.value());
        Thread t1 = new Thread(new IncrementerWorker(longCounter));
        Thread t2 = new Thread(new IncrementerWorker(longCounter));
        Thread t3 = new Thread(new IncrementerWorker(longCounter));
        //Starting the threads
        t1.start();
        t2.start();
        t3.start();
        //Waiting for the end of the work done by the threads
        t1.join();
        t2.join();
        t3.join();
        System.out.println(longCounter.name() + " value after counting with workers ends : " + longCounter.value());
        System.out.println("\n---------------------\n");
    }
}