package repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.College;
import domain.Student;
import repository.CollegeRepository;
import repository.StudentRepository;

@Repository
public class StudentRepositoryJpa implements StudentRepository {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private CollegeRepository collegeDao;
	@Transactional
	public  void addStudent(String id, String name, int age, String collegeId) {
		College college = collegeDao.getCollegeById(collegeId);
		Student student = new Student();
		student.setId(id);
		student.setAge(age);
		student.setCollege(college);
		student.setName(name);
		em.persist(student);
		
	}

	public  List<Student> getAllStudents() {
		Query query=em.createQuery("from Student");
		return (List<Student>) query.getResultList();

	}
}
