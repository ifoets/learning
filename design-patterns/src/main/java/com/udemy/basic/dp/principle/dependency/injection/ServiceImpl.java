package com.udemy.basic.dp.principle.dependency.injection;

public class ServiceImpl implements IService {

	@Override
	public void write(String message) {
		System.out.println(message);
	}
}
