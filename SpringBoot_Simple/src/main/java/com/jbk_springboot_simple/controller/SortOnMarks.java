package com.jbk_springboot_simple.controller;

import java.util.Comparator;


import com.jbk_springboot_simple.entity.Student;

public class SortOnMarks implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		
		if(s1.getMarks() > s2.getMarks())
			return 1;
		else if(s1.getMarks() < s2.getMarks())
			return -1;
		else
			return 0;
	}

}