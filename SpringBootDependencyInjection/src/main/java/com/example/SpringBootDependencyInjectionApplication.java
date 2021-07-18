package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.implement.ImplementDI;
import com.example.pojo.Student;

@SpringBootApplication
@ComponentScan(basePackages  = {"com.pojo"})
public class SpringBootDependencyInjectionApplication {
	@Autowired //it shuld not use under any method that why we use here
	static Student stdObj;
	public static void main(String[] args) {
		//method one to get object of Student class
		//for this method your Student class should be in same package of  SpringBootDependencyInjectionApplication class
		/*
		 * ConfigurableApplicationContext obj =
		 * SpringApplication.run(SpringBootDependencyInjectionApplication.class, args);
		 * Student sObj = (Student)obj.getBean(Student.class); sObj.display();
		 */
		
		//second method
		
		
		 ConfigurableApplicationContext obj= SpringApplication.run(SpringBootDependencyInjectionApplication.class, args);
		System.out.println("nnn "+stdObj);
		//ImplementDI im = (ImplementDI) obj.getBean(ImplementDI.class);
		//System.out.println("nnnm "+im);
		
		
		
		
	}

}
