package pojo;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name ="emp")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	
	
	private String empName;
	
	//@ManyToMany(mappedBy = "emp" ,fetch = FetchType.EAGER) mens load when call
	@ManyToMany(mappedBy = "emp")
	private List<Laptop> laptop;
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	public int getEmpId() {
		return empId;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", laptop=" + laptop + "]";
	}
	

}
