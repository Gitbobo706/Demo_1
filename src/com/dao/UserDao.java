package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Student;
import com.bean.User;

public class UserDao extends BaseDao{
	public boolean existUsername(String username){
		boolean result = false;
		Connection conn = (Connection) getConnection();
		if(conn!=null){
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("select * from user where username=?");
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public boolean addUser(User user){
		boolean result = false;
		Connection conn = (Connection) getConnection();
		if(conn!=null){
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("insert into user(username,password) values(?,?)");
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				int r = ps.executeUpdate();
				if(r>0){
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public User querUserByUsername(String username){
		User user = null;
		Connection conn = getConnection();
		if(conn!=null){
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("select * from user where username=?");
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
}
