package coreJava15;

import java.io.Serializable;

public class Student implements Serializable{
	private int sNo;
	private String sname;
	private float average;
	public Student(int id, String name,float avg) {
		this.sname=name;
		this.sNo=id;
		this.average=avg;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public Student() {
		super();
	}
	public void display() {
		System.out.println("Student No :"+sNo);
		System.out.println("Student Name :"+sname);
		System.out.println("Student Scored :"+average);
	}

}
