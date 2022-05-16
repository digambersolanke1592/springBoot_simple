package com.jbk_springboot_simple.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk_springboot_simple.entity.Student;

@RestController
public class StudentController {
	//here list is the temporary storage container of student
	List<Student> list = new ArrayList<>();
	
	//here we are adding student by using postmapping in container list
	@PostMapping(value = "/saveStudent")//here it is not compulsary to write 'value = '
	public List<Student> saveStudent(@RequestBody Student student) {//here we take List<Student> object because
		//we add list of student from this method
      list.add(student);
	return list;
	}
	//here we retrieve the student by using getmapping from container list
	@GetMapping(value = "/getallstudent")//here it is not compulsary to write 'value = '
	public List<Student> getallstudent(){//here we take List<Student> object because
		//we get(required) list of student from this method
		
		return list;
	}
	//here we retrieve the student by its Id  using getmapping from container list
	@GetMapping(value = "/getstudentbyId/{Id}")//here it is not compulsary to write 'value = '
	public Student getstudentbyId(@PathVariable int Id){//here we take Student object because
		//we get(required) just a single student from this method
		
	Student s = null;
		for (Student student : list) {
			if (student.getStudentId()==Id) {
				s =student;
				break;
			}
		}
		return s;
	}
	
	@PutMapping(value = "/studentSaveUpdate") //here exact below student data comes from URL in requestBody to update by putmapping
	public String studentUpdate(@RequestBody Student student) {
		
		
		String msg ="data is not exist";
//here exact below student2 data comes from stored data from list for iteration to match URL data
		boolean data = false;
		for (Student std : list) {
		if(std.getStudentId()==student.getStudentId()) {
			data = true;
			list.remove(std);
			list.add(student);
			
			msg = "student Data  updated";
			break;
			}
		}
	if(data = false) {//here we can write 'if(!data)' both are same 
		list.add(student);
	return	msg = "new data is added";
	}         
		return msg; 
	}
	
	@DeleteMapping(value = "/DeleteStudent/{Id}")
	public String DeleteStudent(@PathVariable int Id) {
		String msg = "data is not Exist";
		
		for (Student stud : list) {
			if (stud.getStudentId() == Id) {
				
				list.remove(stud);
				msg = "data removed";
			}
		}
		
		return msg;
	}
	@GetMapping(value = "/sort")
	public TreeSet<Student> getallStudentSortbyMarks(){
		
           TreeSet<Student> ts=new TreeSet<>(new SortOnMarks());
		
		   ts.addAll(list);
		return ts;
	}
}
	
