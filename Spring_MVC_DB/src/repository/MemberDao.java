package repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.MemberMapper;
import vo.MemberVO;

@Component
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate){
		this.sessionTemplate = sessionTemplate;
	}
	
	public int insert(MemberVO member){
		MemberMapper mapper = sessionTemplate.getMapper(MemberMapper.class);
		return mapper.insert(member);
	}
	
	public MemberVO select(String id){
		MemberMapper mapper = sessionTemplate.getMapper(MemberMapper.class);
		return mapper.select(id);
	}
}
