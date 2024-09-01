/**
 * A exécuter avec JBang : jbang frequencies-map-with-groupingby-and-counting.jsh
 * <p>
 * Ou ouvrir dans JShell : /open frequencies-map-with-groupingby-and-counting.jsh
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

List<String> daysOfWeek = List.of("Friday", "Thursday", "Thursday", "Saturday", "Thursday", "Thursday", "Monday", "Saturday", "Friday", "Saturday");

Map<String, Long> frequencies = daysOfWeek.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

frequencies.entrySet().iterator().forEachRemaining(System.out::println);