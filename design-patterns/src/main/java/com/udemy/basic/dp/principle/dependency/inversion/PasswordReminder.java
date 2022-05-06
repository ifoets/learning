package com.udemy.basic.dp.principle.dependency.inversion;

/* here Inversion applied  PasswordReminder concrete class depends on  intermediate interface IDBConnection
rather than any concrete class*/
public class PasswordReminder {

	@SuppressWarnings("unused")
	private IDBConnection dbConnection;

	public PasswordReminder(IDBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
}
