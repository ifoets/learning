package com.udemy.basic.dp.principle.dependency.inversion;

/* here BreakInversion directly depends upon concrete class MySqlConnection
	 any modification of MySqlConnection affect object creation*/
public class BreakInversion {

	@SuppressWarnings("unused")
	private MySqlConnection dbConnection;

	public BreakInversion(MySqlConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
}
