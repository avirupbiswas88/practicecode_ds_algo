package com.dustbin.practice;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.List;

public class StreamAPIExamples {

	public static void main(String[] args) {
		
		int[] array = {15,3,29,4,10,33,9,7,16,9};
		
		IntStream.of(array)
				 .distinct()
				 .sorted()
				 .limit(3)
				 .forEach(System.out::println);
		
		List<Integer> newArray = IntStream.of(array)
				 .distinct()
				 .sorted()
				 .limit(3)
				 .boxed()
				 .collect(Collectors.toList());
		System.out.println(newArray);

	}

}
