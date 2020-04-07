package springweb.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import springweb.domain.Student;

@Service
public class StudentService {
	private Map<String,Student> students=new HashMap<>();
	public StudentService() {
		students.put("1", new Student("1","张三",10));
		students.put("2", new Student("2","李四",20));
		students.put("3", new Student("3","王五",30));
	}
	public Student getStudent(String id)
	{
		return students.get(id);
	}
	public Map<String,Student> getAllStudents()
	{
		return students;
	}
}
