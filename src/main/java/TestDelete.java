

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import repository.CollegeRepository;

public class TestDelete {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CollegeRepository collegeDao=context.getBean(CollegeRepository.class);
		//删除id=1的学院，级联删除学生
		collegeDao.deleteById("1");
		//删除id=2的学院，级联删除学生
		collegeDao.deleteById("2");
	}

}
