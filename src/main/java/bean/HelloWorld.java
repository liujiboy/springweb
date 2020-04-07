package bean;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	public void sayHello()
	{
		System.out.println("hello world!");
	}
	public void sayHello(String name)
	{
		System.out.println("hello world! "+name);
	}
}
