package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Student;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class StudentDao extends BaseDao{
	public ArrayList<Student> queryStudentByAll(){
		ArrayList<Student> list = new ArrayList<Student>();
		Connection conn = getConnection();
		if (conn!=null) {
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("select * from student");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Student s = new Student();
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setSex(rs.getString("sex"));
					s.setAge(rs.getInt("age"));
					s.setScore(rs.getInt("score"));
					list.add(s);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public int addStudent(Student s){
		int result = 0;
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement("insert into student(name,sex,age,score) values(?,?,?,?)");
				ps.setString(1, s.getName());
				ps.setString(2, s.getSex());
				ps.setInt(3, s.getAge());
				ps.setInt(4, s.getScore());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					conn.close();
					if(ps!=null){
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public int deleteStudent(int id){
		int result = 0;
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement("delete from student where id = ?");
				ps.setInt(1, id);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					conn.close();
					if(ps!=null){
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;	
	}
	public int updateStudent(Student s){
		int result = 0;
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement("update student set name=?,sex=?,age=?,score=? where id=?");
				ps.setString(1,s.getName());
				ps.setString(2,s.getSex());
				ps.setInt(3,s.getAge());
				ps.setInt(4, s.getScore());
				ps.setInt(5,s.getId());
				result  = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					conn.close();
					if(ps!=null){
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;			
	}
	public Student queryStudentById(int id){
		Student s = new Student();
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement("select * from student where id=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setSex(rs.getString("sex"));
					s.setAge(rs.getInt("age"));
					s.setScore(rs.getInt("score"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					conn.close();
					if(ps!=null){
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return s;
	}
	public ArrayList<Student> queryStudentByRecord(Student student){
		ArrayList<Student> list = new ArrayList<Student>();
		StringBuffer sb = new StringBuffer("select * from student where 1=1 ");
		ArrayList value = new ArrayList();
		if (!"".equals(student.getName())) {
			sb.append("and name = ? ");
			value.add(student.getName());
		}
		if (!"".equals(student.getSex())) {
			sb.append("and sex = ? ");
			value.add(student.getSex());
		}
		if (student.getAge()!=0) {
			sb.append("and age = ? ");
			value.add(student.getAge());
		}
		if (student.getScore()!=0) {
			sb.append("and score = ? ");
			value.add(student.getScore());
		}
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(sb.toString());
				for (int i = 0; i < value.size(); i++) {
					ps.setObject(i+1, value.get(i));
				}
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Student s = new Student();
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setSex(rs.getString("sex"));
					s.setAge(rs.getInt("age"));
					s.setScore(rs.getInt("score"));
					list.add(s);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
