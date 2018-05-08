package com.biz.po;



public class Student {
	private String id;
	private String name;
	private String birthday;
	private String description;
	private int avgscore;
	
	
	//构造方法
	public Student() {
		
	}
	
	//get，set方法
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getavgscore() {
		return avgscore;
	}
	public void setavgscore(int avgscore) {
		this.avgscore = avgscore;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", description=" + description
				+ ", avgscore=" + avgscore + "]";
	}
	
	
	
	
	

}
