package com.udemy.basic.dp.structural.adapter.cls.ex1;

public class ObjectAdapter implements IIntValue {

	IIntValue intval;

	public ObjectAdapter(IIntValue intval) {
		this.intval = intval;
	}

	@Override
	public int getIntValue() {
		return 2 + intval.getIntValue();
	}

}
