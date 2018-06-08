package org.java8.StreamCollectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class ChainConsumers {
    public static void main(String... args) {
        
        List<String> strings = 
                Arrays.asList("one", "two", "three", "four", "five");
        
        List<String> result = new ArrayList<>();
        
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = result::add;
        //System.out.println(c2);
        
        strings.forEach(c1.andThen(c2));
        System.out.println("size of result = " + result.size());
        
        Stream<String> stream1 = Stream.of("one", "two", "three", "four", "five");
        Predicate<? super String> p = Predicate.isEqual("two");
        result.clear();
		stream1
        	.filter (p)
        	.forEach(result::add);
        
        System.out.println(result.size());
        
        
    }
}
