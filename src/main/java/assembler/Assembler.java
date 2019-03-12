package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regService;
	private ChangePasswordService passService;
	
	public Assembler() {
	
		memberDao = new MemberDao();
		regService = new MemberRegisterService(memberDao);
		passService = new ChangePasswordService();
		
		passService.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegService() {
		return regService;
	}

	public ChangePasswordService getPassService() {
		return passService;
	}
	
	
	
	
}
