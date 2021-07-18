package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="student_table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "student_name")
	private StudentName name;
	
	//@Transient //it will not save address column in db
	private String address;
	
	private String phoneNo;
	public int getId() {
		return id;
	}
	/*
	 * public void setId(int id) { this.id = id; }
	 */
	
	public StudentName getName() {
		return name;
	}
	public void setName(StudentName name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", phoneNo=" + phoneNo + "]";
	}
	
}
