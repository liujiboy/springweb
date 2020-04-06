package springweb.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springweb.domain.Student;
import springweb.service.StudentService;
@RestController
public class RestStudentController {
	@Autowired
	private StudentService studentService;
	@RequestMapping(value="/getStudent.do")
	public Student getStudent(String id)
	{
		return studentService.getStudent(id);
	}
	@RequestMapping(value="/getAllStudent.do")
	public Map<String,Student> getAllStudent()
	{
		return studentService.getAllStudents();
	}
}