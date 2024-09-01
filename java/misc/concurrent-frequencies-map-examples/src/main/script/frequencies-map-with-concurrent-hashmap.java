/**
 * A exécuter avec JBang : jbang frequencies-map-with-concurrent-hashmap.java
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

List<String> daysOfWeek = List.of("Friday", "Thursday", "Thursday", "Saturday", "Thursday", "Thursday", "Monday", "Saturday", "Friday", "Saturday");
Map<String, LongAdder> frequencies = new ConcurrentHashMap<>();
Map<String, LongAdder> frequencies2 = new HashMap<>();
Map<String, AtomicInteger> frequencies3 = new HashMap<>();
for (String day : daysOfWeek) {
    frequencies.computeIfAbsent(day, k -> new LongAdder()).increment();
    frequencies2.computeIfAbsent(day, k -> new LongAdder()).increment();
    frequencies3.computeIfAbsent(day, k -> new AtomicInteger(0)).incrementAndGet();
}

frequencies.entrySet().iterator().forEachRemaining(System.out::println);
System.out.println();
frequencies2.entrySet().iterator().forEachRemaining(System.out::println);
System.out.println();
frequencies3.entrySet().iterator().forEachRemaining(System.out::println);