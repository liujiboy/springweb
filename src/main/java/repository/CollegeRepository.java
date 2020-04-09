package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.College;

public interface CollegeRepository extends JpaRepository<College,String>{

	
}
