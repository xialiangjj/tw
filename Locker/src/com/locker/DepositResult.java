package com.locker;

import java.util.Date;

public class DepositResult {
	private String pwd;
	
	private Date depositDate;

	private DepositStatus status;
	
	
	public DepositResult(String pwd,DepositStatus status){
		this.pwd=pwd;
		this.status=status;
		this.depositDate=new Date();
	}
	
	public DepositResult(DepositStatus status){
		this.status=status;
		this.depositDate=new Date();
	}
	
	
	public DepositResult(){
		
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	public DepositStatus getStatus() {
		return status;
	}

	public void setStatus(DepositStatus status) {
		this.status = status;
	}

	
	
}
