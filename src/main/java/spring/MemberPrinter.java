package spring;

public class MemberPrinter {
	public void print(Member member){
		System.out.printf("회원정보 아이디 = %4d , 이름 %s,   이메일 %s  , 등록일  : %tF\n " , member.getId(), member.getName(),member.getEmail(),member.getRegDataTime());
	}
}
