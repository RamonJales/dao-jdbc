package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDao;
import db.DB;
import db.DbException;
import entities.Employee;

public class EmployeeDaoJDBC implements EmployeeDao{
	
	private Connection conn;
	
	public EmployeeDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Employee obj) {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("INSERT INTO employee "
					+ "(Name, Salary, BirthDate) "
					+ "VALUES "
					+ "(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			st.setDouble(2, obj.getSalary());
			st.setDate(3, obj.getBirthDate());
			
			int rowsAffected = st.executeUpdate();
			
			//this logic is optional. It just serves to know the new id. If the table is large and you need to know the position of the inserted object.
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				
				DB.closeReultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Employee obj) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE employee "
					+ "SET Name=?, Salary=?, BirthDate=? "
					+ "WHERE Id=?");
			
			st.setString(1, obj.getName());
			st.setDouble(2, obj.getSalary());
			st.setDate(3, obj.getBirthDate());
			
			st.setInt(4, obj.getId());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM employee WHERE Id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Employee findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM employee WHERE Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Employee obj = new Employee(id, rs.getString("Name"), rs.getDouble("Salary"), rs.getDate("BirthDate"));
				return obj;
			}
			else {
				return null;
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeReultSet(rs);
		}
	}

	@Override
	public List<Employee> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<>();
		
		try {
			st = conn.prepareStatement("SELECT * FROM employee");
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				list.add(new Employee(rs.getInt("Id"), rs.getString("Name"), rs.getDouble("Salary"), rs.getDate("BirthDate")));
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
}