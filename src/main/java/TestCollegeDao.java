


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import dao.CollegeDao;
import domain.College;



public class TestCollegeDao {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CollegeDao collegeDao=context.getBean(CollegeDao.class);
		collegeDao.addCollege("1", "计算机学院");
		collegeDao.addCollege("2", "通信学院");
		College college=collegeDao.getCollegeById("2");
		System.out.printf("id=%s,name=%s\n",college.getId(),college.getName());
	}

}
