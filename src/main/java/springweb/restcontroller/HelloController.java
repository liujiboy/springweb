package springweb.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping(value="/hello.do")
	public String hello(String name)
	{
		return "hello world "+name;
	}
}
