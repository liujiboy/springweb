package service;

import java.util.List;

import domain.Student;

public interface StudentService {
	public  void addStudent(String id, String name, int age, String collegeId);
	public  List<Student> getAllStudents();
}
