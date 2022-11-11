package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.UI.ChaXunTuShuJF;
import com.UI.UserKaiShiJianMian;
import com.entity.Books;
import com.panduan.PanDuan;

public class BooksDao {
	static public int addBooks(Connection con,Books bk)throws Exception{
		
		String sql="insert into Books values(null,?,?,?,?,?,?)";
		PreparedStatement tmt=con.prepareStatement(sql);
		tmt.setString(1, bk.getBookname());
		tmt.setString(2, bk.getZuozhe());
		tmt.setString(3, bk.getZuozhexb());
		tmt.setFloat(4, bk.getJiage());
		tmt.setInt(5, bk.getBookID());
		tmt.setString(6, bk.getBookdesc());
		
		return tmt.executeUpdate();
	}
	static public ResultSet ChaoXunBooks_o(Connection con,Books bk)throws Exception{//管理员图书查询
		StringBuffer sb=new StringBuffer("select * from books b,typebook t where b.bookID=t.bookID");
		
		if(PanDuan.FUtil(bk.getBookname())) {
			sb.append(" and b.bookname like'%"+bk.getBookname()+"%'");
		}
		if(PanDuan.FUtil(bk.getZuozhe())) {
			sb.append(" and b.zuozhe like'%"+bk.getZuozhe()+"%'");
		}
		if(ChaXunTuShuJF.pan) {
			if(bk.getBookID()!=null && bk.getBookID()!=-1) {
				sb.append(" and b.bookID="+bk.getBookID());
			}
		}
		
		PreparedStatement pt =con.prepareStatement(sb.toString());
		return pt.executeQuery(  );
	}
	
	static public ResultSet ChaoXunBooks(Connection con,Books bk)throws Exception{//普通用户查询
		StringBuffer sb=new StringBuffer("select * from books b,typebook t where b.bookID=t.bookID");
		
		if(PanDuan.FUtil(bk.getBookname())) {
			sb.append(" and b.bookname like'%"+bk.getBookname()+"%'");
		}
		if(PanDuan.FUtil(bk.getZuozhe())) {
			sb.append(" and b.zuozhe like'%"+bk.getZuozhe()+"%'");
		}
		if(UserKaiShiJianMian.pan) {
			if(bk.getBookID()!=null && bk.getBookID()!=-1) {
				sb.append(" and b.bookID="+bk.getBookID());
			}
		}
		
		PreparedStatement pt =con.prepareStatement(sb.toString());
		return pt.executeQuery(  );
	}
	
	
	static public int DeleteBooks(Connection con,String booksid)throws Exception{
		String sql = "delete from books where booksID='"+booksid+"'";
		PreparedStatement tmt= con.prepareStatement(sql);
		return tmt.executeUpdate();
	}
	static public int UpDateBooks(Connection con,Books bk)throws Exception{
		String sql="update books set bookname=?,zuozhe=?,zuozhexb=?,jiage=?,bookID=?,bookdesc=? where booksID=?";
		//Statement tmt=con.createStatement();
		
		PreparedStatement tmt=con.prepareStatement(sql);
		tmt.setString(1, bk.getBookname());
		tmt.setString(3, bk.getZuozhexb());
		tmt.setFloat(4, bk.getJiage());
		tmt.setString(2, bk.getZuozhe());
		tmt.setInt(5, bk.getBookID());
		tmt.setString(6, bk.getBookdesc());
		tmt.setInt(7, bk.getBooksID());
		return tmt.executeUpdate();
		
	} 
}
