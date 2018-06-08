package org.java8.StreamCollectors;

import java.util.StringJoiner;

/**
 *
 * @author Jos�
 */
public class Bits {

    public static void main(String[] args) {

        // StringJoiner
    	String a = new String();
    	a = "three";
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        sj.add("one ").add("two").add(a);
        
        
        System.out.println(sj.toString());
    }
}