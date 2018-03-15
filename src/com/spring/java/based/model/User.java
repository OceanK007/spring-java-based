package com.spring.java.based.model;

import java.io.Serializable;

public class User implements Serializable
{
	private static final long serialVersionUID = 3464570229197765058L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
