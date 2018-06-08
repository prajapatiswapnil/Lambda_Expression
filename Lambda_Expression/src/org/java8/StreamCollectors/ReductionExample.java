package org.java8.StreamCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {
    public static void main(String... args) {
        
        List<Integer> list = Arrays.asList(1,4,2,8,0);
        
        Optional<Integer> red = 
        list.stream()
                .reduce(Integer::max);
        
        System.out.println("red = " + red.get());
        System.out.println("red = " + red);
        
        
    }
}
