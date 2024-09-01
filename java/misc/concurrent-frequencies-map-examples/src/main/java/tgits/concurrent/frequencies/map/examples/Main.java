package tgits.concurrent.frequencies.map.examples;

import org.apache.commons.lang3.time.StopWatch;
import tgits.concurrent.frequencies.map.examples.worker.FrequenciesMapUpdater;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String... args) throws InterruptedException {
        System.out.println("Code example with updated frequencies map in a concurrent environment");
        ConcurrentHashMap<String, LongAdder> frequencies = new ConcurrentHashMap<>();
        System.out.println("The frequencies map is initially empty : frequencies.isEmpty() : " + frequencies.isEmpty());
        updateCounterFromThreads(frequencies);
    }

    public static void updateCounterFromThreads(final ConcurrentHashMap<String, LongAdder> frequencies) throws InterruptedException {
        final List<String> allDaysOfWeek = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        final List<String> workingDays = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
        final List<String> weekendDays = List.of("Saturday", "Sunday");
        final int durationOfSleep = 10;

        Thread t1 = new Thread(new FrequenciesMapUpdater(allDaysOfWeek, frequencies, durationOfSleep));
        Thread t2 = new Thread(new FrequenciesMapUpdater(workingDays, frequencies, durationOfSleep));
        Thread t3 = new Thread(new FrequenciesMapUpdater(weekendDays, frequencies, durationOfSleep));
        Thread t4 = new Thread(new FrequenciesMapUpdater(workingDays, frequencies, durationOfSleep));
        //Starting the threads
        StopWatch watch = new StopWatch();
        watch.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        //Waiting for the end of the work done by the threads
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        watch.stop();
        System.out.println("Content of the Map after update by the workers :");
        for (Map.Entry<String, LongAdder> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("\n---------------------\n");
        System.out.println("Time Elapsed: " + watch.getTime());
    }
}