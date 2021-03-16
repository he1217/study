package com.he.study.java8.common;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);

}
