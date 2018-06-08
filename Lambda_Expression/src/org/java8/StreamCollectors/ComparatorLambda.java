package org.java8.StreamCollectors;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//      Comparator<String> comp = new Comparator<String>() {
	//      
	//      @Override
	//      public int compare(String s1, String s2) {
	//
	//          return Integer.compare(s1.length(), s2.length());
	//      }
	//  };
	  
	  Comparator<String> compLambda = (String s2, String s1) ->
	          Integer.compare(s2.length(), s1.length());
	  
	  List<String> list = Arrays.asList("***", "**", "****", "*");
	  Collections.sort(list, compLambda);
	
	  
	  for(String s : list) {
	      System.out.println(s);
	  }
	}
	

}
