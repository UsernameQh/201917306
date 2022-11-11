package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.entity.OrdinaryUsers;

public class OrdinaryUsersDao {
	@SuppressWarnings("null")
	static public OrdinaryUsers OrdinaryUsersLogin(Connection con,OrdinaryUsers ou)throws Exception {
		// TODO Auto-generated constructor stub
		OrdinaryUsers us=null;
		//��ѯ���
		String sql="select * from o_user where o_user='"+ou.getO_user()+"' and o_password='"+ou.getO_user_password()+"'";
		//��ѯִ��
		Statement tmt=con.createStatement();
		ResultSet re=tmt.executeQuery(sql);
		//�ж�re�Ƿ�����һ����¼���еĻ��Ѽ�¼����user��
		if (re.next()) {
			us=new OrdinaryUsers();//ʵ���������ж���ȥ���ú���
			us.setO_userid(re.getInt(1));
			us.setO_user(re.getString(2));
			us.setO_user_password(re.getString(3));
		}
		return us;
		
	}
	static public boolean Register(Connection con,OrdinaryUsers oud)throws Exception{
		String sql="select * from o_user where o_user='"+oud.getO_user()+"'";
		Statement tmt_1=con.createStatement();
		ResultSet re=tmt_1.executeQuery(sql);
		if(re.next()) {
			return false;
		}else {
			String sql_1="insert into o_user values(null,?,?)";
			PreparedStatement tmt=con.prepareStatement(sql_1);
			tmt.setString(1, oud.getO_user());
			tmt.setString(2, oud.getO_user_password());
			tmt.executeUpdate();
			return true;
		}
		
		
	}
	static public int Update_User(Connection con,String id,String pass)throws Exception {//��ͨ�û��޸�����
		String sql="update o_user set o_password=? where o_usersid=?";
		PreparedStatement tmt=con.prepareStatement(sql);
		
		tmt.setString(1, pass);
		tmt.setString(2, id);
		
		return tmt.executeUpdate();
	}
	static public ResultSet Query_allUser(Connection con)throws Exception {//��ͨ�û�ȫ����ѯ
		String sql="select * from o_user";
		Statement tmt=con.createStatement();
		ResultSet re=tmt.executeQuery(sql);
		
		return re;
	}
	static public int delete(Connection con,String id)throws Exception {//ɾ���û�
		String sql = "delete from o_user where o_usersid='"+id+"'";
		PreparedStatement tmt= con.prepareStatement(sql);
		return tmt.executeUpdate();
	}
	
}
