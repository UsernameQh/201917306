package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.Normalizer.Form;

public class BDtil {
	static String Driver="com.mysql.cj.jdbc.Driver";
	static String name="root";//���ݿ�����
	static String password="123456";//���ݿ�����
	static String sql_url="jdbc:mysql://localhost/tushu?serverTimezone=UTC&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
	static public Connection LianJie()throws Exception{//�������ݿ�
		Class.forName(Driver);
		Connection con=DriverManager.getConnection(sql_url, name, password);
		return con;
	}

	static public void CloseCon(Connection con)throws Exception{//�ر����ݿ�
		if (con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		BDtil bd=new BDtil();
		try {
			bd.LianJie();
			System.out.println("�������ݿ�ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("�������ݿ�ʧ��");
			e.printStackTrace();
		}
	}
}
