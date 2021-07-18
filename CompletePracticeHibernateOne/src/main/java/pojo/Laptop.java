package pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="laptop")
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int laptopId;
	
	@Column(name = "lap_name")
	private String Name;
	
	/*
	 * @ManyToOne private Employee emp;
	 */
	@ManyToMany
	private List<Employee> emp;
	
	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}

	public int getLaptopId() {
		return laptopId;
	}
	
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", Name=" + Name + ", emp=" + emp + "]";
	}

}
