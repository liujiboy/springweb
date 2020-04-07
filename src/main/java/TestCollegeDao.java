


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import domain.College;
import repository.CollegeRepository;



public class TestCollegeDao {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CollegeRepository collegeDao=context.getBean(CollegeRepository.class);
		collegeDao.addCollege("1", "计算机学院");
		collegeDao.addCollege("2", "通信学院");
		College college=collegeDao.getCollegeById("2");
		System.out.printf("id=%s,name=%s\n",college.getId(),college.getName());
	}

}
