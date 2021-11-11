package dao;

import dao.impl.EmployeeDaoJDBC;
import db.DB;

public class DaoFactory {
	
	//Creats the connection
	public static EmployeeDao createEmployeeDao() {
		return new EmployeeDaoJDBC(DB.getConnection());
	}
}