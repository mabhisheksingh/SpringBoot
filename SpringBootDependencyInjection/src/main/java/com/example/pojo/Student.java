package com.example.pojo;

import org.springframework.stereotype.Component;

//@Component//bydefault bean name is student
@Component("stud1") // now this class bean name is stud1
public class Student {
	private int Id;
	private String name;
	private String phoneNo;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public void display() {
		System.out.println("Its object created succesfully......" );
	}
	
	

}
