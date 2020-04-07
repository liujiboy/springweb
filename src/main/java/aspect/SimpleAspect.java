package aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SimpleAspect {
	@Before("execution (** bean.HelloWorld.sayHello(..) ) ")
	public void beforeSayHello()
	{
		System.out.println("before say hello");
	}
	@After("execution (** bean.HelloWorld.sayHello(..) ) ")
	public void afterSayHello()
	{
		System.out.println("after say hello");
	}
}
