package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.Normalizer.Form;

public class BDtil {
	static String Driver="com.mysql.cj.jdbc.Driver";
	static String name="root";//数据库名字
	static String password="123456";//数据库密码
	static String sql_url="jdbc:mysql://localhost/tushu?serverTimezone=UTC&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
	static public Connection LianJie()throws Exception{//连接数据库
		Class.forName(Driver);
		Connection con=DriverManager.getConnection(sql_url, name, password);
		return con;
	}

	static public void CloseCon(Connection con)throws Exception{//关闭数据库
		if (con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		BDtil bd=new BDtil();
		try {
			bd.LianJie();
			System.out.println("连接数据库成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("连接数据库失败");
			e.printStackTrace();
		}
	}
}
