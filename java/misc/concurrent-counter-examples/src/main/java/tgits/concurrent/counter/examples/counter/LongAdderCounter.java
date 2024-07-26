package tgits.concurrent.counter.examples.counter;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderCounter implements LongCounter {

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
