package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value = {"/","/test"})
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "MainController.test message");
		mv.addObject("now", System.currentTimeMillis());
		mv.setViewName("test");
		return mv;
	}
	
	@RequestMapping(value = "/admin/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "MainController.login message");
		mv.addObject("now", System.currentTimeMillis());
		mv.setViewName("login");
		return mv;
	}
}
