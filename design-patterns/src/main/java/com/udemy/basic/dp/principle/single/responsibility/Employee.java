package com.udemy.basic.dp.principle.single.responsibility;

import java.util.Date;

@SuppressWarnings("unused")
public class Employee {

	private String id;
	private String namme;
	private String address;
	private Date doj;

	// below methods breaking the Single Responsibility
	// it should be in HR and Finance class
	/*
	public boolean isPromotionDueCurrentYear() {
		// promotion logic
		return false;
	}

	public double calIncomeTaxCurretYear() {
		// Tax calculation logic
		return 0.0;
	}
	*/
	//getter setter
}