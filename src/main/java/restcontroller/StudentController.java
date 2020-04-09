package restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.Student;
import service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/student/add/{id}/{name}/{age}/{collegeId}",method=RequestMethod.POST)
	public boolean addStudent(@PathVariable String id, @PathVariable String name, @PathVariable int age, @PathVariable String collegeId) {
		studentService.addStudent(id, name, age, collegeId);
		return true;
	}

	@RequestMapping(value = "/student/delete/{id}",method=RequestMethod.DELETE)
	public boolean addStudentById(String id) {
		studentService.deleteStudentById(id);
		return true;
	}
	@RequestMapping(value = "/student/all",method=RequestMethod.GET,produces = { "application/json; charset=UTF-8" })
	public List<Student> getAllStudents() {
		List<Student> students=studentService.getAllStudents();
		for(Student s:students)
		{
			s.getCollege().setStudents(null);
		}
		return students;
	}

}
