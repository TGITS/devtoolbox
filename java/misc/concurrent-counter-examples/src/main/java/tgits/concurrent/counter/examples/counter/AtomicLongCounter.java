package tgits.concurrent.counter.examples.counter;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongCounter implements LongCounter {

    private final AtomicLong counter;
    private final String name;

    public AtomicLongCounter(String name) {
        this.counter = new AtomicLong(0);
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void increment() {
        this.counter.incrementAndGet();
    }

    @Override
    public long value() {
        return counter.longValue();
    }
}
