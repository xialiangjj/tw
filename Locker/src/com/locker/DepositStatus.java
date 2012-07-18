package com.locker;

public enum DepositStatus {

	SUCCESS("成功"), STOCK_IS_FULL("库存已满");
	
	private String message;

	DepositStatus(String message) {
		this.message = message;

	}

	public String getMessage() {
		return message;
	}

}
