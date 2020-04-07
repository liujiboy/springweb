package repository;

import java.util.List;

import domain.Student;

public interface StudentRepository {

	public void addStudent(String id, String name, int age, String collegeId);

	public List<Student> getAllStudents();
}
