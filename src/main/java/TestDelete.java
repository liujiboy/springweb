

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import service.CollegeService;

public class TestDelete {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CollegeService collegeService=context.getBean(CollegeService.class);
		collegeService.deleteAllColleges();
	}

}
