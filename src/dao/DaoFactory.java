package dao;

import dao.impl.EmployeeDaoJDBC;
import db.DB;

public class DaoFactory {
	
	public static EmployeeDao createEmployeeDao() {
		return new EmployeeDaoJDBC(DB.getConnection());
	}
}