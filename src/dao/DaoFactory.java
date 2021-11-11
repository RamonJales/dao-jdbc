package dao;

import db.DB;
import entities.Employee;

public class DaoFactory {
	
	public static Employee createEmployeeDao() {
		return new EmployeeDaoJDBC(DB.getConnection());
	}
}