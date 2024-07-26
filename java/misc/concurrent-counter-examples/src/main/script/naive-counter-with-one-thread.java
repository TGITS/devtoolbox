/// usr/bin/env jbang "$0" "$@" ; exit $?
// A exécuter avec JBang : jbang naive-counter-with-one-thread.java

import java.time.Duration;

class NotSynchronizedLongCounter {

    private long counter;
    private final String name;

    public NotSynchronizedLongCounter(String name) {
        this.counter = 0;
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void increment() {
        counter++;
    }

    public long value() {
        return counter;
    }
}

class IncrementerWorker implements Runnable {

    private final NotSynchronizedLongCounter counter;

    public IncrementerWorker(NotSynchronizedLongCounter counter) {
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
        NotSynchronizedLongCounter notSynchronizedLongCounter = new NotSynchronizedLongCounter("notSynchronizedLongCounter");
        updateCounterFromThreads(notSynchronizedLongCounter);
    }

    public static void updateCounterFromThreads(NotSynchronizedLongCounter longCounter) throws InterruptedException {
        System.out.println(longCounter.name() + " initial value : " + longCounter.value());
        Thread t1 = new Thread(new IncrementerWorker(longCounter));
        //Starting the thread
        t1.start();
        //Waiting for the end of the work done by the thread
        t1.join();
        System.out.println(longCounter.name() + " value after counting with workers ends : " + longCounter.value());
        System.out.println("\n---------------------\n");
    }
}