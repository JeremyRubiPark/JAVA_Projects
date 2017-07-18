package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDao;
import vo.MemberVO;

@Component
public class MemberService {
	@Autowired
	private MemberDao dao;
	public void setDao(MemberDao dao){
		this.dao = dao;
	}
	
	public boolean join(MemberVO member){
		if(member==null ||
				member.getMemberId()==null ||
				member.getMemberPw()==null ||
				member.getPhone()==null){
			return false;
		}
		else{
			dao.insert(member);
			return true;
		}
	}
	
	public boolean login(String inputId,String inputPw){
		MemberVO member = dao.select(inputId);
		if(member==null){
			return false;
		}
		else if(member.getMemberPw().equals(inputPw) == true){
			return true;
		}else{
			return false;
		}
	}
}
