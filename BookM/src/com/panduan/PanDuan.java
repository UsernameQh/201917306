package com.panduan;

public class PanDuan {
	public static boolean TUtil(String str) {
		if(str==null||"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean FUtil(String str) {
		if (str!=null&&!"".equals(str.trim())) {
			return true;
		}else{
			return false;
		}
	}
}