package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.entity.User;

public class UserDao {
	
	public static User Login(Connection con,User user)throws Exception{
		User Us=null;
		//获取管理员用户名和密码
		String u=user.getUserName();
		String p=user.getPassWord();
		//数据库查询语句
		String sql = "select * from user where UserName='"+u+"' and PassWord='"+p+"'";
		//执行查询
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		//判断re是否有下一条记录，有的话把记录存入user中
		if (rs.next()) {
			Us = new User();
			Us.setID(rs.getInt(1));
			Us.setUserName(rs.getString(2));
			Us.setPassWord(rs.getString(3));		
		}
		return Us;
	}
	static public int Update_Andmi(Connection con,String id,String pass)throws Exception {//管理员用户修改密码
		String sql="update user set PassWord=? where ID=?";
		PreparedStatement tmt=con.prepareStatement(sql);
		
		tmt.setString(1, pass);
		tmt.setString(2, id);
		
		return tmt.executeUpdate();
	}
}

