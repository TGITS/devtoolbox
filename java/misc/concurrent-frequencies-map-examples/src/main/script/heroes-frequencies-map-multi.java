/// usr/bin/env jbang "$0" "$@" ; exit $?
// A exécuter avec JBang : jbang heroes-frequencies-map-multi.java

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class FrequenciesMapUpdater implements Runnable {

    private final List<String> lines;
    private final Map<String, LongAdder> frequencies;

    public FrequenciesMapUpdater(final List<String> lines, final Map<String, LongAdder> frequencies) {
        this.lines = lines;
        this.frequencies = frequencies;
    }

    @Override
    public void run() {
        // A line has the following structure : id, name, gender, eye color, race, hair color, publisher, alignment
        // We remove the first line which contains the header
        lines.remove(0);
        for (String line : lines) {
            //System.out.println(line);
            String[] items = line.split(",");
            //For the code example, we only need the publisher, which is the column of index 6 (the 7th column)
            frequencies.computeIfAbsent(items[6].strip(), k -> new LongAdder()).increment();
            try {
                Thread.sleep(Duration.ofMillis(10));
            } catch (InterruptedException ie) {
                //A minimalist management of the Exception not suitable in a real project
                ie.printStackTrace();
            }
        }
    }
}

class Main {

    public static void main(String... args) throws IOException, InterruptedException {
        System.out.println("Code example with a frequency map in a concurrent environment");
        final Map<String, LongAdder> frequencies = new ConcurrentHashMap<>();
        System.out.println("The frequencies map is initially empty - frequencies.isEmpty() : " + frequencies.isEmpty());

        List<Thread> workers;

        //The list of threads is created from the stream of pathes.
        //The lines of each file in the provided directory are extracted and given to one of the thread
        try (Stream<Path> pathes = Files.list(Path.of("./data/multi"))) {
            workers = pathes
                    .map(path -> createThread(path, frequencies))
                    .collect(Collectors.toList());
        }

        //Each thread is started
        for (Thread worker : workers) {
            worker.start();
        }

        //Waiting for the end of the work done by the threads
        for (Thread worker : workers) {
            worker.join();
        }

        //Displaying the content of the frequency map
        for (Map.Entry<String, LongAdder> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n---------------------\n");
    }

    //Utility method to manage the IOException
    private static Thread createThread(final Path path, final Map<String, LongAdder> frequencies) {
        try {
            return new Thread(new FrequenciesMapUpdater(Files.readAllLines(path), frequencies));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}