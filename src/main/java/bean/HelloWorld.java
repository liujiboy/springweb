package bean;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	public String sayHello()
	{
		return "hello world!";
	}
}
