

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import domain.Student;
import repository.StudentRepository;
import service.StudentService;

public class TestStudentService {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentService studentService=context.getBean(StudentService.class);
		studentService.addStudent("1", "foo1", 10, "1");
		studentService.addStudent("2", "foo2", 11, "1");
		studentService.addStudent("3", "foo3", 12, "1");
		studentService.addStudent("4", "bar1", 13, "2");
		List<Student> students = studentService.getAllStudents();
		for (Student s : students) {
			System.out.printf("id=%s,name=%s,age=%d,college.id=%s,college.name=%s\n", s.getId(), s.getName(), s.getAge(), s.getCollege().getId(),
					s.getCollege().getName());
		}
	}
}
