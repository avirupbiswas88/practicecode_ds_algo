package com.dustbin.practice;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("springpractice.xml");
		//Student student = (Student) context.getBean("student");
		//System.out.println(student.toString());
		
		LinkedList<Integer> list = new LinkedList<>();
		//list.contains(o)
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(1, 2);
		map.put(2, 2);
		//map.containsKey(key)
		for(Integer val:map.keySet()) {
			if(map.get(val) > 1) {
				
			}
		}
		System.out.println(map);

	}

}
