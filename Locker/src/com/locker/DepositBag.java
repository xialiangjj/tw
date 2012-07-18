package com.locker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DepositBag {

	public Map<String,MyBag> bagsInfo;
	
	private List<Integer> capacitys;
	
	
	public DepositBag(List<Integer> capacitys){
		this.capacitys=capacitys;
		this.bagsInfo=new HashMap<String,MyBag>();
	}

	public DepositResult deposit(MyBag bag)  {
		if(isBeyondMaxStock())
			return new DepositResult(DepositStatus.STOCK_IS_FULL);
		GeneratePwd generatePwd=new GeneratePwd();
		String pwd=generatePwd.generatePwd();
		this.bagsInfo.put(pwd, bag);
		return  new DepositResult(pwd,DepositStatus.SUCCESS);
	}

	

	public boolean isBeyondMaxStock() {
		for(Integer stockNum:capacitys){
			if(bagsInfo.size()+1 <= stockNum )
				return false;
		}
		return true;
	}
	
	public MyBag getBag(String pwd){
		if(!bagsInfo.containsKey(pwd))
			throw new BagNotExistException();
		MyBag box= bagsInfo.get(pwd);
		bagsInfo.remove(box);
		return box;
	}
	
}
