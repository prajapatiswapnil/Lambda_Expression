package org.java8.StreamCollectors;


import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author José
 */
public class FirstPredicates {
    
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        Stream<String> stream1 = Stream.of("one", "two", "three", "four", "five");;
        Predicate<String> p1 = s -> s.length() > 3 ;
        
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");
        System.out.println("Stream.............");
        stream
                .filter(p2.or(p3))
                .forEach(s -> System.out.println(s));
        System.out.println("Stream 1.............");
        stream1
        .filter(p1)
        .forEach(b -> System.out.println(b));
    }
}
