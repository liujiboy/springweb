package dao;

import java.util.List;

import domain.Student;

public interface StudentDao {

	public void addStudent(String id, String name, int age, String collegeId);

	public List<Student> getAllStudents();
}
