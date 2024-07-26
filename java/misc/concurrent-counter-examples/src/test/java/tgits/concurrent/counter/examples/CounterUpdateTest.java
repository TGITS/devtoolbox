package tgits.concurrent.counter.examples;

import org.junit.jupiter.api.RepeatedTest;
import tgits.concurrent.counter.examples.counter.AtomicLongCounter;
import tgits.concurrent.counter.examples.counter.LongAdderCounter;
import tgits.concurrent.counter.examples.counter.LongCounter;
import tgits.concurrent.counter.examples.counter.SynchronizedLongCounter;
import tgits.concurrent.counter.examples.worker.IncrementerWorker;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CounterUpdateTest {

    private final RandomGenerator randomGeneratorDefault = RandomGenerator.getDefault();

    private void updateCounterFromThreads(LongCounter longCounter, int numberOfThreads, int numberOfRepetitions, int durationOfSleep) throws InterruptedException {
        if (numberOfThreads <= 0) {
            throw new IllegalArgumentException("The provided number of threads should be strictly positive");
        }

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            threads.add(new Thread(new IncrementerWorker(longCounter, numberOfRepetitions, durationOfSleep)));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    private void testLongCounter(LongCounter longCounter) throws InterruptedException {
        int numberOfThreads = randomGeneratorDefault.nextInt(2, 5);
        int numberOfRepetitions = randomGeneratorDefault.nextInt(50, 150);
        int durationOfSleep = randomGeneratorDefault.nextInt(10, 50);
        int expectedCounterValue = numberOfThreads * numberOfRepetitions;

        updateCounterFromThreads(longCounter, numberOfThreads, numberOfRepetitions, durationOfSleep);

        assertThat(longCounter.value()).isEqualTo(expectedCounterValue);
    }

    @RepeatedTest(5)
    void testSynchronizedLongCounter() throws InterruptedException {
        LongCounter synchronizedLongCounter = new SynchronizedLongCounter("synchronizedLongCounter");
        testLongCounter(synchronizedLongCounter);
    }

    @RepeatedTest(5)
    void testAtomicLongCounter() throws InterruptedException {
        LongCounter atomicLongLongCounter = new AtomicLongCounter("atomicLongLongCounter");
        testLongCounter(atomicLongLongCounter);
    }

    @RepeatedTest(5)
    void testLongAdderCounter() throws InterruptedException {
        LongCounter longAdderLongCounter = new LongAdderCounter("longAdderLongCounter");
        testLongCounter(longAdderLongCounter);
    }

}
