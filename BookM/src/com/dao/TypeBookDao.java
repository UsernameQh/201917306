package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.TypeBook;
import com.mysql.cj.protocol.Resultset;
import com.panduan.PanDuan;

import com.jdbc.BDtil;

public class TypeBookDao {
	public static int BookAdd(Connection con,TypeBook tb)throws Exception{
		String typename=tb.getTypebook();
		String desc=tb.getDesc();
		String sql="insert into typebook values(null,'"+typename+"','"+desc+"')";
		Statement stmt = con.createStatement();
		return  stmt.executeUpdate(sql);
		 
	}
public static ResultSet ChaXun(Connection con , TypeBook tb)throws Exception{
		
		StringBuffer sb= new StringBuffer("select * from typebook");
		if(PanDuan.FUtil(tb.getTypebook())) {
			sb.append(" and typebook like'%"+tb.getTypebook()+"%'");
		}
		PreparedStatement pt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pt.executeQuery();
	}
public static int delete(Connection con,String tb)throws Exception {
	String sql="delete from typebook where bookID=?";
	PreparedStatement tmt=con.prepareStatement(sql);
	tmt.setString(1, tb);
	return tmt.executeUpdate();
	
    }
public static int Updata(Connection con,TypeBook tb)throws Exception{
	String sql="update typebook set typebook=?,descw=? where bookID=?";
	//Statement tmt=con.createStatement();
	
	PreparedStatement tmt=con.prepareStatement(sql);
	tmt.setString(1, tb.getTypebook());
	tmt.setString(2, tb.getDesc());
	tmt.setString(3, tb.getId());
	return tmt.executeUpdate();
}
}