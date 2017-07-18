package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.MemberService;
import vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	public void setService(MemberService service){
		this.service = service;
	}
	
	@RequestMapping(value="/joinForm.do", method=RequestMethod.GET)
	public String joinForm(){
		return "join_form";
	}

	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String join(MemberVO member) {
		if (service.join(member)) {
			return "join_success";
		} else {
			return "join_fail";
		}

	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(String userId, String userPw, HttpSession session){
		if(service.login(userId, userPw) == true){
			session.setAttribute("loginId", userId);
			return "login_success";
		}else{
			return "login_fail";
		}
	}
}
