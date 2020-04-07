package dao.spring;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.CollegeDao;
import dao.StudentDao;
import domain.College;
import domain.Student;

@Repository
public class StudentDaoHibernateTemplate implements StudentDao {
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Autowired
	private CollegeDao collegeDao;
	@Transactional
	public  void addStudent(String id, String name, int age, String collegeId) {
		College college = collegeDao.getCollegeById(collegeId);
		Student student = new Student();
		student.setId(id);
		student.setAge(age);
		student.setCollege(college);
		student.setName(name);
		hibernateTemplate.save(student);
		
	}

	public  List<Student> getAllStudents() {
		return (List<Student>) hibernateTemplate.find("from Student");

	}
}
