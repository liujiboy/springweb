package dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.CollegeDao;
import dao.StudentDao;
import domain.College;
import domain.Student;

//@Repository
public class StudentDaoHibernate implements StudentDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession()
	{
		return sessionFactory.getCurrentSession();
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
		currentSession().save(student);
		
	}
	@Transactional(readOnly=true)
	public  List<Student> getAllStudents() {
		Query query=currentSession().createQuery("from Student");
		return query.list();

	}
}
