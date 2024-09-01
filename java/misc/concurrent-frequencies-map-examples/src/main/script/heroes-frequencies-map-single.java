/// usr/bin/env jbang "$0" "$@" ; exit $?
// A exécuter avec JBang : jbang heroes-frequencies-map-single.java

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

class FrequenciesMapUpdater {

    private final List<String> lines;
    private final Map<String, LongAdder> frequencies;

    public FrequenciesMapUpdater(final List<String> elements, final Map<String, LongAdder> frequencies) {
        this.lines = elements;
        this.frequencies = frequencies;
    }

    public void execute() {
        // A line has the following structure : id,name,Gender,Eye color,Race,Hair color,Publisher,Alignment
        // We remove the first line which contains the header
        lines.remove(0);
        for (String line : lines) {
            System.out.println(line);
            String[] elements = line.split(",");
            //For the code example, we only need the publisher, which is the column of inex 6 (the 7th)
            frequencies.computeIfAbsent(elements[6].strip(), k -> new LongAdder()).increment();
        }
    }
}

class Main {

    public static void main(String... args) throws IOException {
        System.out.println("Code example with updated frequencies map in a concurrent environment");
        Map<String, LongAdder> frequencies = new HashMap<>();
        System.out.println("The frequencies map is initially empty : frequencies.isEmpty() : " + frequencies.isEmpty());
        Path path = Path.of("./data/single/heroes_information_simplified.csv");
        List<String> lines = Files.readAllLines(path);
        new FrequenciesMapUpdater(lines, frequencies).execute();
        for (Map.Entry<String, LongAdder> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("\n---------------------\n");
    }

}