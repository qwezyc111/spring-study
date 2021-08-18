package com.zzz.iocbeanlifecycle;

import org.springframework.stereotype.Component;

@Component
public class Tank {
	int id;
	String name;

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

	public Tank() {
		System.out.println("tank create");
	}
}
