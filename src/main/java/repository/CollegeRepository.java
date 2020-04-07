package repository;

import domain.College;

public interface CollegeRepository {
	
	public void addCollege(String id, String name);

	public College getCollegeById(String id);

	public void deleteById(String id);
	
}
