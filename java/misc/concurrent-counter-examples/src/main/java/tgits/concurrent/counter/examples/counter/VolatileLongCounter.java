package tgits.concurrent.counter.examples.counter;

public class VolatileLongCounter implements LongCounter {

    private volatile long counter;
    private final String name;

    public VolatileLongCounter(String name) {
        this.counter = 0;
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void increment() {
        counter += 1;
    }

    @Override
    public long value() {
        return counter;
    }
}
