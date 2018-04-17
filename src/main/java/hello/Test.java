package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}

}
