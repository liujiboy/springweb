package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping(value="/index")
	public ModelAndView index(@RequestParam(value="name", defaultValue="Ji") String name)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", name);
		mv.setViewName("/welcome");
		return mv;
		
	}
}
