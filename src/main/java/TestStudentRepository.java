

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import domain.Student;
import repository.StudentRepository;

public class TestStudentRepository {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentRepository studentDao=context.getBean(StudentRepository.class);
		studentDao.addStudent("1", "foo1", 10, "1");
		studentDao.addStudent("2", "foo2", 11, "1");
		studentDao.addStudent("3", "foo3", 12, "1");
		studentDao.addStudent("4", "bar1", 13, "2");
		List<Student> students = studentDao.getAllStudents();
		for (Student s : students) {
			System.out.printf("id=%s,name=%s,age=%d,college.id=%s,college.name=%s\n", s.getId(), s.getName(), s.getAge(), s.getCollege().getId(),
					s.getCollege().getName());
		}
	}
}
