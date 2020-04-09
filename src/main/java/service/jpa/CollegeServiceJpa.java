package service.jpa;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.College;
import repository.CollegeRepository;
import service.CollegeService;
@Service
public class CollegeServiceJpa implements CollegeService{
	private final Logger logger = LoggerFactory.getLogger(CollegeServiceJpa.class);
	@Autowired
	private CollegeRepository  collegeRepository;

	@Transactional
	public void addColleges()
	{
		collegeRepository.save(new College("1","计算机学院"));
		logger.debug("插入计算机学院成功");
		collegeRepository.save(new College("2","通信学院"));
		logger.debug("插入通信学院成功");
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
