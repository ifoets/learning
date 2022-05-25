package com.udemy.basic.grpc.utils;

import com.udemy.proto.Person;

public class Utils {

	public static Person getPerson() {
		/*
		 * for wrapper .setAge(Int32Value.newBuilder() .setValue(20) .build())
		 */
		return Person.newBuilder()
		        .setAge(20)
		        .setName("Abhimanyu kumar")
		        .build();

	}
}
