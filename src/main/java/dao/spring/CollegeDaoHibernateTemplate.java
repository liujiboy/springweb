package dao.spring;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.CollegeDao;
import domain.College;

@Repository
public class CollegeDaoHibernateTemplate implements CollegeDao{
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Transactional
	public void addCollege(String id, String name) {
		College college = new College(id, name);
		hibernateTemplate.save(college);
	}

	public College getCollegeById(String id) {
		return hibernateTemplate.get(College.class, id);
	}

	@Transactional
	public void deleteById(String id) {

		College college = hibernateTemplate.get(College.class, id);
		hibernateTemplate.delete(college);

	}
}
