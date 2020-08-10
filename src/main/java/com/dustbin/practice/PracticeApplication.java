package com.dustbin.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("springpractice.xml");
		Student student = (Student) context.getBean("student");
		System.out.println(student.toString());
	}

}
