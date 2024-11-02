/// usr/bin/env jbang "$0" "$@" ; exit $?
// A exécuter avec JBang : jbang frequencies-map-in-concurrent-context.java

import java.time.Duration;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.List;

class FrequenciesMapUpdater implements Runnable {

    private final List<String> elements;
    private final ConcurrentHashMap<String, LongAdder> frequencies;

    public FrequenciesMapUpdater(final List<String> elements, final ConcurrentHashMap<String, LongAdder> frequencies) {
        this.elements = elements;
        this.frequencies = frequencies;
    }

    @Override
    public void run() {
        for (String element:elements) {
            //If there is alreay a LongAdder object for this entry, we simply increment it
            //If there is no entry yet, we create it and increment it.
            frequencies.computeIfAbsent(element, k -> new LongAdder()).increment();
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
        System.out.println("Code example with updated frequencies map in a concurrent environment");
        ConcurrentHashMap<String, LongAdder> frequencies = new ConcurrentHashMap<>();
        System.out.println("The frequencies map is initially empty : frequencies.isEmpty() : " + frequencies.isEmpty());
        updateCounterFromThreads(frequencies);
    }

    public static void updateCounterFromThreads(final ConcurrentHashMap<String, LongAdder> frequencies) throws InterruptedException {
        List<String> allDaysOfWeek = List.of("Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday", "Sunday");
        List<String> workingDays = List.of("Monday", "Tuesday", "Wednesday","Thursday", "Friday");
        List<String> weekendDays = List.of("Saturday", "Sunday");

        Thread t1 = new Thread(new FrequenciesMapUpdater(allDaysOfWeek, frequencies));
        Thread t2 = new Thread(new FrequenciesMapUpdater(workingDays, frequencies));
        Thread t3 = new Thread(new FrequenciesMapUpdater(weekendDays, frequencies));

        //Starting the threads
        t1.start();
        t2.start();
        t3.start();

        //Waiting for the end of the work done by the threads
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Content of the Map after update by the workers :");
        for(Map.Entry<String, LongAdder> entry:frequencies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("\n---------------------\n");
    }
}