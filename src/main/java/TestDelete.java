

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import dao.CollegeDao;

public class TestDelete {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CollegeDao collegeDao=context.getBean(CollegeDao.class);
		//删除id=1的学院，级联删除学生
		collegeDao.deleteById("1");
		//删除id=2的学院，级联删除学生
		collegeDao.deleteById("2");
	}

}
