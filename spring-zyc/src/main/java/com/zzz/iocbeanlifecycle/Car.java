package com.zzz.iocbeanlifecycle;

import org.springframework.stereotype.Component;

@Component
public class Car {
	int id;
	String name;
	private Tank tank;

	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank) {
		this.tank = tank;
	}

	public Car() {
		System.out.println("car create");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
