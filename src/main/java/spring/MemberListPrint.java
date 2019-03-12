package spring;

import java.util.Collection;

public class MemberListPrint {
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	public MemberListPrint(MemberDao memberDao, MemberPrinter memberPrinter) {
		super();
		this.memberDao = memberDao;
		this.memberPrinter = memberPrinter;
	}
	
	public void printAll(){
		Collection<Member> members = memberDao.selectAll();
		members.forEach(x->memberPrinter.print(x));
	}
	
}
