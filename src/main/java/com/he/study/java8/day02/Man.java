package com.he.study.java8.day02;

public class Man {

	private Godness god;

	public Man() {
	}

	public Man(Godness god) {
		this.god = god;
	}

	public Godness getGod() {
		return god;
	}

	public void setGod(Godness god) {
		this.god = god;
	}

	@Override
	public String toString() {
		return "Man [god=" + god + "]";
	}

}
