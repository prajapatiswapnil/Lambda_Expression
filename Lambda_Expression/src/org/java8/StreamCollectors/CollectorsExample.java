package org.java8.StreamCollectors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.java8.StreamCollectors.Person;


/**
 *
 * @author José
 */
public class CollectorsExample {

    public static void main(String... args)  {
        
        List<Person> persons = new ArrayList<>();
        
        try (
            BufferedReader reader = 
                new BufferedReader(
                    new InputStreamReader(  (new FileInputStream("C:\\Users\\Swapnil\\eclipse-workspace\\Lambda\\src\\org\\java8\\StreamCollectors\\people.txt"))
                        ));

            Stream<String> stream = reader.lines();
        ) {

            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                persons.add(p);
                return p;
                    })
                    .forEach(System.out::println);
                
            
        } catch (IOException ioe) {
            System.out.println(ioe);
        } 
        
        Optional<Person> opt = 
        persons.stream().filter(p -> p.getAge() >= 20).min(Comparator.comparing(Person::getAge));
        System.out.println(opt);
        
        Optional<Person> opt2 = 
        persons.stream().max(Comparator.comparing(Person::getAge));
        System.out.println(opt2);
        
        Map<Integer, List<String>> map = 
        persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge, 
                                Collectors.mapping(
                                        Person::getName, 
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println(map.toString());
        System.out.println(map.values());
        System.out.println(map.keySet());
        
        Collection<List<String>> mName = map.values();
        Collection<Integer> pName = map.keySet();
        
        List<String> n1 = new ArrayList<>();
        int j = 0;
        mName.forEach(System.out::println);
        
        for (Iterator<List<String>> i = mName.iterator(); i.hasNext();)
        {
        		
        	 n1.addAll(j, i.next());
        	j++;
        }
        
        System.out.println("...." + n1);
    	   
    }
}
