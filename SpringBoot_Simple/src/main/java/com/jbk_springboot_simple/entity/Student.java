package com.jbk_springboot_simple.entity;

public class Student {
private int studentId;
private String studentName;
private float Marks;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int studentId, String studentName, float marks) {
	super();
	this.studentId = studentId;
	this.studentName = studentName;
	this.Marks = marks;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public float getMarks() {
	return Marks;
}
public void setMarks(float marks) {
	Marks = marks;
}
@Override
public String toString() {
	return "Student [studentId=" + studentId + ", studentName=" + studentName + ", Marks=" + Marks + "]";
}


}
