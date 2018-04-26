package controller;

import annotation.RequestMapping;
import annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping(value="/hello.do")
	public String hello(String name)
	{
		return "hello world "+name;
	}
}
