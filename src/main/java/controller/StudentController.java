package controller;

import java.util.HashMap;
import java.util.Map;

import annotation.RequestMapping;
import annotation.RestController;
import domain.Student;

@RestController
public class StudentController {
	private Map<String,Student> students=new HashMap<>();
	public StudentController()
	{
		students.put("1", new Student("1","张三",10));
		students.put("2", new Student("2","李四",20));
		students.put("3", new Student("3","王五",30));
	}
	@RequestMapping(value="/getStudent.do")
	public Student getStudent(String id)
	{
		return students.get(id);
	}
	@RequestMapping(value="/getAllStudent.do")
	public Map<String,Student> getAllStudent()
	{
		return students;
	}
}
