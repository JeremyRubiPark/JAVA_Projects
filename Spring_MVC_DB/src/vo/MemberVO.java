package vo;

public class MemberVO {
	private String memberId;
	private String memberPw;
	private String phone;
	private String email;
	public MemberVO(String memberId, String memberPw, String phone, String email) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.phone = phone;
		this.email = email;
	}
	public MemberVO(){
		
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString(){
		return "MemberVO [memberId=" + memberId + ", memberPw=" + memberPw + ", phone=" + phone + ", email=" + email
                + "]";
	}
}
