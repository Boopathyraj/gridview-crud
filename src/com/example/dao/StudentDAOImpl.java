package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.bean.Student;


public class StudentDAOImpl implements StudentDAO{

	public static Connection connection = null;
	public static Statement statement = null;
	
	public void saveDetail(Student std) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.100.1.30:1521:kurnia", "KURNIADEV",
				"system");
		statement = connection.createStatement();
		
		statement.executeUpdate("insert into regss values('"+std.getName()+"','"+std.getCourse()+"','"+std.getAddress()+"',"+std.getCutoff()+")");
		
	}

	
	public void deleteEntries(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.100.1.30:1521:kurnia", "KURNIADEV",
				"system");
		statement = connection.createStatement();
		statement.executeQuery("delete from regss where name='"+name+"' ");
		
	}

	
		
		


	public ResultSet retriveEmployeeDetails() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.100.1.30:1521:kurnia", "KURNIADEV",
				"system");
		statement = connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from regss");
		return resultSet;
	}



	public ResultSet updateTable(String name) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.100.1.30:1521:kurnia", "KURNIADEV",
				"system");
		statement = connection.createStatement();
		System.out.println(name);
		ResultSet resultSet=statement.executeQuery("select * from regss where name='"+name+"' " );
		/*System.out.println("rsgawe"+ resultSet.findColumn(name));*/
		return resultSet;
	}


	@Override
	public void updateDetail(Student std) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.100.1.30:1521:kurnia", "KURNIADEV",
				"system");
		statement = connection.createStatement();
		
		statement.executeUpdate("update regss set course= '"+std.getCourse()+"',address= '"+std.getAddress()+"',cutoff= "+std.getCutoff()+" where name='"+std.getName()+"' ");
		
	}

		
	}
	


