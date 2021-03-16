package com.he.study.java8.common;

public class TestDefaultInterface {

	public static void main(String[] args) {
		SubClass sc = new SubClass();
		System.out.println(sc.getName());

		MyInterface.show();
	}

}
