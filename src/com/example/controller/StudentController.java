package com.example.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.Student;
import com.example.dao.StudentDAO;
import com.example.dao.StudentDAOImpl;



@Controller
public class StudentController {

	StudentDAO stdDAO=new StudentDAOImpl();
	Student std=new Student();
	
	
	@RequestMapping(value="/nextpage.do",method=RequestMethod.GET)
	public String view(){
		System.out.println("controller");
		return "Page";
	}
	
	
	
	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public @ResponseBody
	Student savedeatils(@RequestBody Student bean) throws ClassNotFoundException, SQLException {
		System.out.println("COntroller");
		std.setName(bean.getName());
		std.setCourse(bean.getCourse());
		std.setAddress(bean.getAddress());
		std.setCutoff(bean.getCutoff());
		System.out.println(std.getAddress());

		stdDAO.saveDetail(std);
	
	return std;
	}
	@RequestMapping(value = "/retrive.do", method = RequestMethod.POST)
	public @ResponseBody
	List<Student> saveTransaction() throws ClassNotFoundException, SQLException {
	
	List<Student> stdList= new ArrayList<Student>();
	
	
	Student stud;
	
		
		ResultSet result=stdDAO.retriveEmployeeDetails();
			
		
		
		while(result.next())
		{
			stud=new Student();
			stud.setName(result.getString(1));
			stud.setCourse(result.getString(2));
			stud.setAddress(result.getString(3));
			stud.setCutoff(result.getInt(4));
			stdList.add(stud);
		}
		return stdList;
		

	}
	
	@RequestMapping(value="/deletelist.do",method=RequestMethod.POST,  produces = "application/json", consumes = "application/json")
	public @ResponseBody List<Student> deleteDetails(@RequestBody List<Student> numberList) throws ClassNotFoundException, SQLException {

		for(int i=0;i<numberList.size();i++)
		{
			stdDAO.deleteEntries(numberList.get(i).getName());
		}
		List<Student> localList = new ArrayList<Student>();
		Student stud=null;
		ResultSet result=stdDAO.retriveEmployeeDetails();	
		while(result.next())
		{
			stud=new Student();
			stud.setName(result.getString(1));
			stud.setCourse(result.getString(2));
			stud.setAddress(result.getString(3));
			stud.setCutoff(result.getInt(4));
			
			localList.add(stud);
		}
		return localList;
	}
	@RequestMapping(value="/update.do",method=RequestMethod.POST,  produces = "application/json", consumes = "application/json")
	public @ResponseBody Student Details(@RequestBody List<Student> numberList) throws ClassNotFoundException, SQLException {
		
		System.out.println(numberList.get(0).getName());
		ResultSet result = null;
		for(int i=0;i<numberList.size();i++)
		{
			 result=stdDAO.updateTable(numberList.get(i).getName());
		}
		
		/*result.next();
		System.out.println(result.getString(1));*/
		
/*		List<Student> localList = new ArrayList<Student>();
*/		Student stud;
		stud=new Student();
		while(result.next())
		{
/*			stud=new Student();
*/			stud.setName(result.getString(1));
			stud.setCourse(result.getString(2));
			stud.setAddress(result.getString(3));
			stud.setCutoff(result.getInt(4));
			
			
		}
		return stud;
	}
	@RequestMapping(value = "/details.do", method = RequestMethod.POST)
	public @ResponseBody
	Student updatedeatils(@RequestBody Student bean) throws ClassNotFoundException, SQLException {
		System.out.println("COntroller");
		std.setName(bean.getName());
		std.setCourse(bean.getCourse());
		std.setAddress(bean.getAddress());
		std.setCutoff(bean.getCutoff());
		System.out.println(std.getAddress());

		stdDAO.updateDetail(std);
	
	return std;
	}
	
}
