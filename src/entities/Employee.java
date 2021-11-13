package entities;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Employee {
	
	private Integer id;
	private String name;
	private Double salary;
	private Date birthDate;
		
	public Employee() {}
	
	public Employee(Integer id, String name, Double salary, Date birthDate) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		
		return "Employee [id = " + id + ", name = " + name + ", salary = " + salary + ", birthDate = " + formatter.format(birthDate.toLocalDate()) + "]";
	}
	
	
	
}
