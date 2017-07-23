package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping({"/test","/"})
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("role", "testController");
		mv.setViewName("interceptor");
		return mv;
	}
	
	@RequestMapping("/admin/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("role", "loginController");
		return mv;
	}
	
	@RequestMapping("/admin/oldLogin")
	public ModelAndView oldLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("oldLogin");
		mv.addObject("role", "oldLoginController");
		return mv;
	}
}
