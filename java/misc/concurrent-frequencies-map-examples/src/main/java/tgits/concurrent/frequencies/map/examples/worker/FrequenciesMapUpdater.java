package tgits.concurrent.frequencies.map.examples.worker;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class FrequenciesMapUpdater implements Runnable {

    private final List<String> elements;
    private final ConcurrentHashMap<String, LongAdder> frequencies;
    private final int durationOfSleep;

    public FrequenciesMapUpdater(final List<String> elements, final ConcurrentHashMap<String, LongAdder> frequencies, int durationOfSleep) {
        if (durationOfSleep <= 0) {
            throw new IllegalArgumentException("The sleep time should be strictly positive");
        }
        this.elements = elements;
        this.frequencies = frequencies;
        this.durationOfSleep = durationOfSleep;
    }

    @Override
    public void run() {
        for (String element : elements) {
            //If there is alreay a LongAdder object for this entry, we simply increment it
            //If there is no entry yet, we create it and increment it.
            frequencies.computeIfAbsent(element, k -> new LongAdder()).increment();
            try {
                Thread.sleep(Duration.ofMillis(durationOfSleep));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
