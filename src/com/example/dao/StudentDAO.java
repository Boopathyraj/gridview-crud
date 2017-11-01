package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.bean.Student;


public interface StudentDAO {

	void deleteEntries(String name) throws ClassNotFoundException, SQLException;

	ResultSet retriveEmployeeDetails() throws ClassNotFoundException, SQLException;

	void saveDetail(Student std) throws ClassNotFoundException, SQLException;

	ResultSet updateTable(String name) throws ClassNotFoundException, SQLException;

	void updateDetail(Student std) throws ClassNotFoundException, SQLException;


}
