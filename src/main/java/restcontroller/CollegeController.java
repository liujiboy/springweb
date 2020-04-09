package restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.College;
import service.CollegeService;

@RestController
public class CollegeController {
	@Autowired
	private CollegeService collegeService;
	@RequestMapping(value="/college/add",method=RequestMethod.GET)
	public boolean addColleges()
	{
		collegeService.addColleges();
		return true;
	}
	@RequestMapping(value="/college/{id}",method=RequestMethod.GET,produces = { "application/json; charset=UTF-8" })
	public College getCollegeById(@PathVariable String id)
	{
		Optional<College> college=collegeService.getCollegeById(id);
		if(college.isPresent())
		{
			return new College(college.get().getId(),college.get().getName());
		}
		else
		{
			return null;
		}
	}
	@RequestMapping(value="/college/delete",method=RequestMethod.DELETE)
	public boolean deleteAllColleges()
	{
		collegeService.deleteAllColleges();
		return true;
	}
}
