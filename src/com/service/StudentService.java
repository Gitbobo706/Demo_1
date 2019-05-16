package com.service;

import java.util.ArrayList;

import com.bean.Student;
import com.dao.StudentDao;
import com.sun.swing.internal.plaf.basic.resources.basic;

public class StudentService {
	public ArrayList<Student> listStudent(){
		StudentDao dao = new StudentDao();
		ArrayList<Student> list = dao.queryStudentByAll();
		return list;
	}
	public boolean addStudent(Student student){
		boolean result = false;
		StudentDao dao = new StudentDao();
		int flag = dao.addStudent(student);
		if (flag>0) {
			return true;
		}
		return result;
	}
	public boolean deleteStudent(int id){
		boolean result = false;
		StudentDao dao = new StudentDao();
		int falg = dao.deleteStudent(id);
		if (falg>0) {
			return true;
		}
		return result;
	}
	public boolean updateStudent(Student s){
		boolean result = false;
		StudentDao dao = new StudentDao();
		int flag = dao.updateStudent(s);
		if (flag>0) {
			return true;
		}
		return result;
	}
	public Student queryStudentById(int id){
		StudentDao dao = new StudentDao();
			return dao.queryStudentById(id);
	}
	public ArrayList<Student> queryStudentByRecord(Student student){
		StudentDao dao = new StudentDao();
		return dao.queryStudentByRecord(student);
	}
}
