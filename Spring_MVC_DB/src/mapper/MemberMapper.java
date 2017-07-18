package mapper;

import vo.MemberVO;

public interface MemberMapper {
	public int insert(MemberVO member);
	public MemberVO select(String id);
}
