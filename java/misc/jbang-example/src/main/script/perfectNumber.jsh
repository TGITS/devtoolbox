// A exécuter avec JBang : jbang perfectNumber.jsh

import java.util.stream.Collectors;
import java.util.stream.IntStream;

int sumOfDividers(int value){
	return IntStream.rangeClosed(1, value).filter(i -> value % i == 0).sum();
}

var maxItems = 100;
System.out.println("Perfect Numbers up to : " + maxItems);
String list = IntStream.rangeClosed(1, maxItems).filter(num -> sumOfDividers(num) == 2  * num).mapToObj(i -> ((Integer) i).toString()).collect(Collectors.joining(", "));
System.out.println(">> " + list);
