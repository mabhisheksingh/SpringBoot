package com.example.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pojo.Student;

@Component
public class ImplementDI {
	
	@Autowired
	Student std;
	
	
	public void dis() {
		System.out.println("Instance of Student : "+ std);
		
		std.display();
		System.out.println("Instance of Student : "+ std);
	}
	

}
