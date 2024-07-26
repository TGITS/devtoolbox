package tgits.concurrent.counter.examples.worker;

import tgits.concurrent.counter.examples.counter.LongCounter;

import java.time.Duration;

public class IncrementerWorker implements Runnable {

    private final LongCounter counter;
    private final int numberOfRepetition;
    private final int durationOfSleep;

    public IncrementerWorker(LongCounter counter) {
        this(counter, 100, 10);
    }

    public IncrementerWorker(LongCounter counter, int numberOfRepetitions, int durationOfSleep) {
        if ((numberOfRepetitions <= 0) || (durationOfSleep <= 0)) {
            throw new IllegalArgumentException("The number of repetitions and the sleep time should be both strictly positive");
        }
        this.counter = counter;
        this.numberOfRepetition = numberOfRepetitions;
        this.durationOfSleep = durationOfSleep;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfRepetition; i++) {
            counter.increment();
            try {
                Thread.sleep(Duration.ofMillis(durationOfSleep));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
