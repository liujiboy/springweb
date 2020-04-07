import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import dao.HelloWorld;
import dao.Person;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloWorld hello = context.getBean(HelloWorld.class);
		hello.sayHello();
		hello.sayHello("abc");
		Person p=context.getBean(Person.class);
		p.getAge();
		p.getName();
		p.setAge(-1);
	}

}
