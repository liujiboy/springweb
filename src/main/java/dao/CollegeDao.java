package dao;

import domain.College;

public interface CollegeDao {
	
	public void addCollege(String id, String name);

	public College getCollegeById(String id);


	public void deleteById(String id);
	
}
