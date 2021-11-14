package tests;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dao.DaoFactory;
import dao.EmployeeDao;
import entities.Employee;

public class Tests {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Employee> list = new ArrayList<>();
		EmployeeDao dao = DaoFactory.createEmployeeDao();
		
		System.out.println("========Insert-test!========");
		
		Employee obj1 = new Employee(1, "maria das graças", 1500.00, Date.valueOf(LocalDate.of(2000, 06, 26)));
		Employee obj2 = new Employee(2, "Julia azevedo", 2200.12, Date.valueOf(LocalDate.of(1990, 1, 12)));
		Employee obj3 = new Employee(3,"lucas inacio", 1450.00, Date.valueOf(LocalDate.of(1998, Month.OCTOBER, 30)));
		Employee obj4 = new Employee(4, "Pedro silva", 650.15, Date.valueOf(LocalDate.of(2003, Month.FEBRUARY, 5)));
		
		dao.insert(obj1);
		dao.insert(obj2);
		dao.insert(obj3);
		dao.insert(obj4);
				
		Methods.printAll(list, dao);
		
		System.out.println();
		
		System.out.println("========FindById-test!========");
		
		System.out.println(dao.findById(2));
		System.out.println(dao.findById(4));
		
		System.out.println();
		
		System.out.println("======Update-test!========");
		
		obj1.setName("Juliana maria");
		obj1.setSalary(2500.00);
		
		dao.update(obj2);
		
		System.out.println("Update executed!");
		
		System.out.println();
		
		System.out.println("========DeleteById-test!========");
		
		dao.deleteById(1);
		dao.deleteById(2);
		dao.deleteById(3);
		dao.deleteById(4);
		
		list = dao.findAll();
		
		Methods.printAll(list, dao);
		
		System.out.println("Test finished!");
	}

}
