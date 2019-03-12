package spring;

import java.time.LocalDateTime;

import javassist.bytecode.DuplicateMemberException;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao2) {
		this.memberDao = memberDao2;
		
	}

	public Long register(RegisterRequest req) throws DuplicateMemberException{
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new DuplicateMemberException("duplicate email " + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(),req.getPassword(),req.getName(),LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}

}
