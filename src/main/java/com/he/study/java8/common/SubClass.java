package com.he.study.java8.common;

public class SubClass /*extends MyClass*/ implements MyFunName, MyInterface {

	@Override
	public String getName() {
		return MyInterface.super.getName();
	}

}
