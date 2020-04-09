package service.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.College;
import repository.CollegeRepository;
import service.CollegeService;
@Service
public class CollegeServiceJpa implements CollegeService{
	@Autowired
	private CollegeRepository  collegeRepository;
	
	@Transactional
	public void addColleges()
	{
		collegeRepository.save(new College("1","计算机学院"));
		collegeRepository.save(new College("2","通信学院"));
	}
	@Transactional
	public void deleteAllColleges()
	{
		collegeRepository.deleteAll();
	}
	@Override
	public Optional<College> getCollegeById(String id) {
		
		return collegeRepository.findById(id);
	}
}
