package repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.College;
import repository.CollegeRepository;

@Repository

public class CollegeRepositoryJpa implements CollegeRepository{
	@PersistenceContext
	private EntityManager em;
	@Transactional
	public void addCollege(String id, String name) {
		College college = new College(id, name);
		em.persist(college);
	}

	public College getCollegeById(String id) {
		return em.find(College.class, id);
	}
	@Transactional
	public void deleteById(String id) {
		College college = em.find(College.class, id);
		em.remove(college);
	}
}
