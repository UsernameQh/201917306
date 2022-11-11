package com.ModifyingData;

import java.sql.Connection;

import com.dao.OrdinaryUsersDao;
import com.jdbc.BDtil;

public class Modifying_Data {
	String id;
	String user;
	String pss;
	int i;
	public boolean Modifying(String id,String pss) {
		this.id=id;
		this.pss=pss;
		try {
			Connection con=BDtil.LianJie();
			i=OrdinaryUsersDao.Update_User(con, this.id,this.pss);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1) {
			return true;
		}else {
			return false;
		}
	}
}
