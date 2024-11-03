package tgits.concurrent.frequencies.map.examples;

import org.junit.jupiter.api.RepeatedTest;
import tgits.concurrent.frequencies.map.examples.worker.FrequenciesMapUpdater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.random.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class FrequenciesMapUpdaterTest {

    private final RandomGenerator randomGeneratorDefault = RandomGenerator.getDefault();

    private void updateCounterFromThreads(final List<String> elements, final int numberOfThreads, final ConcurrentHashMap<String, LongAdder> frequencies, final int durationOfSleep) throws InterruptedException {
        if (numberOfThreads <= 0) {
            throw new IllegalArgumentException("The provided number of threads should be strictly positive");
        }

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            threads.add(new Thread(new FrequenciesMapUpdater(elements, frequencies, durationOfSleep)));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    @RepeatedTest(5)
    void testLongCounter() throws InterruptedException {
        final int numberOfThreads = randomGeneratorDefault.nextInt(2, 5);
        final List<String> allDaysOfWeek = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        final int durationOfSleep = randomGeneratorDefault.nextInt(10, 50);
        final ConcurrentHashMap<String, LongAdder> frequencies = new ConcurrentHashMap<>();

        updateCounterFromThreads(allDaysOfWeek, numberOfThreads, frequencies, durationOfSleep);

        for (Map.Entry<String, LongAdder> entry : frequencies.entrySet()) {
            assertThat(entry.getValue().intValue()).isEqualTo(numberOfThreads);
        }
    }
}
