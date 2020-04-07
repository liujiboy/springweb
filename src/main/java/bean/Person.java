package bean;

import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age<0)
			throw new RuntimeException("age<0");
		this.age = age;
	}
	
}
