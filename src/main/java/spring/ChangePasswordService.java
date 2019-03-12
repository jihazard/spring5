package spring;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	public void changePassword(String email,String oldPw,String newPw){
		Member member = memberDao.selectByEmail(email);
		if(member == null) throw new MemberNotFoundException();
		
		member.changePassword(oldPw,newPw);
		memberDao.update(member);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
}
