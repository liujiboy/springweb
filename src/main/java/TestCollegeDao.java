


import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import domain.College;
import service.CollegeService;



public class TestCollegeDao {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CollegeService collegeService=context.getBean(CollegeService.class);
		collegeService.addColleges();
		Optional<College> college=collegeService.getCollegeById("2");
		System.out.printf("id=%s,name=%s\n",college.get().getId(),college.get().getName());
	}

}
