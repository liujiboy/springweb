package aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SimpleAspect {
	@Before("execution (* bean.HelloWorld.sayHello(..) ) ")
	public void beforeSayHello()
	{
		System.out.println("before say hello");
	}
	@After("execution (* bean.HelloWorld.sayHello(..) ) ")
	public void afterSayHello()
	{
		System.out.println("after say hello");
	}
	@AfterReturning("execution (* bean.Person.get*(..) ) ")
	public void afterReturning()
	{
		System.out.println("afterReturning get*");
	}
	@AfterThrowing("execution (* bean.Person.*(..) ) ")
	public void afterThrowing()
	{
		System.out.println("afterThrowing throw a exception");
	}

	
}
