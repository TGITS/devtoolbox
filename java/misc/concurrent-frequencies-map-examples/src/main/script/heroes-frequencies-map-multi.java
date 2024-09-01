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

    public FrequenciesMapUpdater(final List<String> elements, final Map<String, LongAdder> frequencies) {
        this.lines = elements;
        this.frequencies = frequencies;
    }

    @Override
    public void run() {
        // A line has the following structure : id,name,Gender,Eye color,Race,Hair color,Publisher,Alignment
        // We remove the first line which contains the header
        lines.remove(0);
        for (String line : lines) {
            //System.out.println(line);
            String[] elements = line.split(",");
            //For the code example, we only need the publisher, which is the column of inex 6 (the 7th)
            frequencies.computeIfAbsent(elements[6].strip(), k -> new LongAdder()).increment();
            try {
                Thread.sleep(Duration.ofMillis(10));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}

class Main {

    public static void main(String... args) throws IOException, InterruptedException {
        System.out.println("Code example with updated frequencies map in a concurrent environment");
        final Map<String, LongAdder> frequencies = new ConcurrentHashMap<>();
        System.out.println("The frequencies map is initially empty : frequencies.isEmpty() : " + frequencies.isEmpty());

        List<Thread> workers;

        try (Stream<Path> pathes = Files.list(Path.of("./data/multi"))) {
            workers = pathes
                    .map(path -> createThread(path, frequencies))
                    .collect(Collectors.toList());
        }

        for (Thread worker : workers) {
            worker.start();
        }

        for (Thread worker : workers) {
            //Waiting for the end of the work done by the threads
            worker.join();
        }

        for (Map.Entry<String, LongAdder> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n---------------------\n");
    }

    private static Thread createThread(final Path path, final Map<String, LongAdder> frequencies) {
        try {
            return new Thread(new FrequenciesMapUpdater(Files.readAllLines(path), frequencies));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}