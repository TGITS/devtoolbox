import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

Collection <String> someGeneric = Set.of("to".repeat(2));

String whoAmIDealingWith = switch (someGeneric) {
    case List<String> l -> String.format("A List ! With first element : <%s>", l.get(0));
    case Set<String> s -> String.format("A Set ! Does it contains our favorite variable name ? <%s>", s.contains("toto"));
    case Queue<String> q -> String.format("A Queue ! Let's get its head off ! <%s>", q.element());
    default -> someGeneric.getClass().getName();
};