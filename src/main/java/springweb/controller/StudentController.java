package springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springweb.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@RequestMapping(value="/showAllStudents.do")
	public ModelAndView showAllStudents()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("students", studentService.getAllStudents());
		mv.setViewName("/showAllStudents.jsp");
		return mv;
	}
}
