package dao;

import java.util.List;

import entities.Employee;

public interface EmployeeDao {
	
	void insert(Employee obj);
	void update(Employee obj);
	void deleteById(Integer id);
	Employee findById(Integer id);
	List<Employee> findAll();
}