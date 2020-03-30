package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotationConfigApplicationContext {

	public static void main(String[] args) {
		 ApplicationContext context = 
		          new AnnotationConfigApplicationContext(Application.class);
		      MessagePrinter printer = context.getBean(MessagePrinter.class);
		      printer.printMessage();
		      String buffer=context.getBean(String.class);
		      System.out.println(buffer);
		      System.out.println(context.getBean("buffer"));
	}

}
