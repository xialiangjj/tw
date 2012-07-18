package com.locker;

import java.util.ArrayList;
import java.util.List;

public class GeneratePwd {	
	
	private List<String> pwdContainer=new ArrayList<String>();
	
	public String generatePwd() {
		String pwd=generateRadom();
		pwdContainer.add(pwd);
		return pwd;
	}



	private String generateRadom() {
		String str = "";
		for(int i=0;i<7;i++){
			str = str+ this.getRandomNumber(); 
		}
		if(pwdContainer.contains(str))
			str= generatePwd();
		return str;
	}


	
	protected int getRandomNumber(){
		return (int)(Math.random()*10);
	}

}
