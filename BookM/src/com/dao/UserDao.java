package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.entity.User;

public class UserDao {
	
	public static User Login(Connection con,User user)throws Exception{
		User Us=null;
		//��ȡ����Ա�û���������
		String u=user.getUserName();
		String p=user.getPassWord();
		//���ݿ��ѯ���
		String sql = "select * from user where UserName='"+u+"' and PassWord='"+p+"'";
		//ִ�в�ѯ
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		//�ж�re�Ƿ�����һ����¼���еĻ��Ѽ�¼����user��
		if (rs.next()) {
			Us = new User();
			Us.setID(rs.getInt(1));
			Us.setUserName(rs.getString(2));
			Us.setPassWord(rs.getString(3));		
		}
		return Us;
	}
	static public int Update_Andmi(Connection con,String id,String pass)throws Exception {//����Ա�û��޸�����
		String sql="update user set PassWord=? where ID=?";
		PreparedStatement tmt=con.prepareStatement(sql);
		
		tmt.setString(1, pass);
		tmt.setString(2, id);
		
		return tmt.executeUpdate();
	}
}

