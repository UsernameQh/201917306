package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.entity.BorrowBooks;
import com.jdbc.BDtil;

public class BorrowDao {
	static public int ShenQing(Connection con,BorrowBooks bbk)throws Exception {//状态表添加借书审核状态的记录
		String sql="insert into jieshuzhuangtaibiao values(null,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement tmt= con.prepareStatement(sql);
		tmt.setString(1, bbk.getZhuangtai());//向问号添加值
		tmt.setString(2, bbk.getUserID());
		tmt.setString(3, bbk.getUserName());
		tmt.setString(4, bbk.getBooksName());
		tmt.setString(5, bbk.getZuozhe());
		tmt.setString(6, bbk.getZuozhexb());
		tmt.setFloat(7,  (float)bbk.getJiage());
		tmt.setString(8, bbk.getTypeid());
		tmt.setString(9, bbk.getTypebook());
		tmt.setString(10, bbk.getBookDesc());
		return tmt.executeUpdate();
		
	}
	static public ResultSet ShenQC(Connection con,String zt)throws Exception {//审核查询
		
		String sql="select * from jieshuzhuangtaibiao where zhuangtai='"+zt+"'";
		Statement st = con.createStatement();
		 
		return st.executeQuery(sql);
	}
	static public ResultSet Query_Application(Connection con,int id,String zt)throws Exception{
		String sql="select * from jieshuzhuangtaibiao where userID='"+id+"' and zhuangtai='"+zt+"'";
		Statement st = con.createStatement();
		 
		return st.executeQuery(sql);
	}
	static public int PastPrial(Connection con,String id)throws Exception{//过审方法,//暂时没用到
		String sql="delete from jieshuzhuangtaibiao where Loan_formid='"+id+"'";
		PreparedStatement tmt = con.prepareStatement(sql);
		return tmt.executeUpdate();
	}
	static public int Changing_State(Connection con,String zt,String id)throws Exception{//审时改变状态
		String sql="update jieshuzhuangtaibiao set zhuangtai=? where Loan_formid=?";
		PreparedStatement tmt= con.prepareStatement(sql);
		tmt.setString(1, zt);
		tmt.setString(2, id);
		return tmt.executeUpdate();
	}

}

