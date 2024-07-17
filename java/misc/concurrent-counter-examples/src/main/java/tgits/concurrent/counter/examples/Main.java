package tgits.concurrent.counter.examples;

import org.apache.commons.lang3.time.StopWatch;
import tgits.concurrent.counter.examples.counter.*;
import tgits.concurrent.counter.examples.worker.AdderWorker;

public class Main {

    public static void main(String... args) throws InterruptedException {
        System.out.println("Code examples with updated counter in concurrent environment");
        LongCounter notSynchronizedLongCounter = new NotSynchronizedLongCounter("notSynchronizedLongCounter");
        updateCounterFromThreads(notSynchronizedLongCounter);

        LongCounter synchronizedLongCounter = new SynchronizedLongCounter("synchronizedLongCounter");
        updateCounterFromThreads(synchronizedLongCounter);

        LongCounter longAdderLongCounter = new LongAdderLongCounter("longAdderLongCounter");
        updateCounterFromThreads(longAdderLongCounter);

        LongCounter atomicLongLongCounter = new AtomicLongLongCounter("atomicLongLongCounter");
        updateCounterFromThreads(atomicLongLongCounter);

    }

    public static void updateCounterFromThreads(LongCounter longCounter) throws InterruptedException {
        System.out.println(longCounter.name() + " initial value : " + longCounter.value());
        Thread t1 = new Thread(new AdderWorker(longCounter));
        Thread t2 = new Thread(new AdderWorker(longCounter));
        Thread t3 = new Thread(new AdderWorker(longCounter));
        StopWatch watch = new StopWatch();
        watch.start();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        watch.stop();
        System.out.println(longCounter.name() + " value after counting with workers ends : " + longCounter.value());
        System.out.println("Time Elapsed: " + watch.getTime());
        System.out.println("\n---------------------\n");
    }
}