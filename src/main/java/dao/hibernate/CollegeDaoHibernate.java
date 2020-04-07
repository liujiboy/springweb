package dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.CollegeDao;
import domain.College;

//@Repository
public class CollegeDaoHibernate implements CollegeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	

	@Transactional
	public void addCollege(String id, String name) {
		College college = new College(id, name);
		currentSession().save(college);
	}
	@Transactional(readOnly=true)
	public College getCollegeById(String id) {
		return currentSession().get(College.class, id);
	}

	@Transactional
	public void deleteById(String id) {

		College college = currentSession().get(College.class, id);
		currentSession().delete(college);

	}
}
