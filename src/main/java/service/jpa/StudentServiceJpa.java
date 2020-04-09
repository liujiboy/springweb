package service.jpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.College;
import domain.Student;
import repository.CollegeRepository;
import repository.StudentRepository;
import service.StudentService;
@Service
public class StudentServiceJpa implements StudentService {
	private final Logger logger = LoggerFactory.getLogger(StudentServiceJpa.class);

	@Autowired
	private CollegeRepository  collegeRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Transactional
	public void addStudent(String id, String name, int age, String collegeId) {
		logger.debug("id=%s,name=%s,age=%d,collegeId=%s",id,name,age,collegeId);
		Optional<College> college = collegeRepository.findById(collegeId);
		if(!college.isPresent())
			throw new RuntimeException("collegeId="+collegeId+"的college不存在!");
		Student student = new Student();
		student.setId(id);
		student.setAge(age);
		student.setCollege(college.get());
		student.setName(name);
		studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
