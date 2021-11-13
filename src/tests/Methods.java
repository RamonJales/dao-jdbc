package tests;

import java.util.List;

import dao.EmployeeDao;
import entities.Employee;

public class Methods {
	
	public static void printAll(List<Employee> list, EmployeeDao dao) {
		list = dao.findAll();

		if (!list.isEmpty()) {
			for (Employee employee : list) {
				System.out.println(employee);
			}
		}
		else {
			System.out.println("Database is empty!");
		}
	}
}
