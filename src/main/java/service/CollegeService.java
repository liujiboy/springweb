package service;

import java.util.Optional;

import domain.College;

public interface CollegeService {

	public void addColleges();
	public Optional<College> getCollegeById(String id);
	public void deleteAllColleges();
}
