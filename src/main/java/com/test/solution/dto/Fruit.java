package com.test.solution.dto;

import java.util.List;

public class Fruit {
	
	private String name;
	private int age;
	private String color;
	private String tast;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTast() {
		return tast;
	}
	public void setTast(String tast) {
		this.tast = tast;
	}
	
	@Override
	public String toString() {
		return "Fruit [name=" + name + ", age=" + age + ", color=" + color + ", tast=" + tast + "]";
	}
	
	public Fruit() {
		super();
	}
	public Fruit(String name, int age, String color, String tast) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
		this.tast = tast;
	}
	
	public Fruit(String name, String age, String color, String tast) {
		super();
		this.name = name;
		this.age = Integer.parseInt(age);
		this.color = color;
		this.tast = tast;
	}
	
	public static Fruit of(List<String> parts) {
		if(parts==null || parts.size()!=4)
			throw new RuntimeException("Invalid data to transform list to Fruit object.");
		return new Fruit(parts.get(0), parts.get(1), parts.get(2), parts.get(3));
	}
	

}
