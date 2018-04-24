package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	@RequestMapping(value="/add")
	public double add(double a,double b)
	{
		return a+b;
	}
	@RequestMapping(value="/mul")
	public double mul(double a,double b)
	{
		return a*b;
	}
	@RequestMapping(value="/sin")
	public double sin(double a)
	{
		return Math.sin(a);
	}
}
