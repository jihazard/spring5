package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberListPrint;
import spring.MemberPrinter;
import spring.MemberRegisterService;

@Configuration
public class AppCtx {
	
	@Bean
	public MemberDao memberDao(){
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService regService(){
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changeService(){
		ChangePasswordService pwdService = new ChangePasswordService();
		pwdService.setMemberDao(memberDao());
		return pwdService;
	}
	
	@Bean
	public MemberPrinter memberPrinter(){
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrint listPrinter(){
		return new MemberListPrint(memberDao(),memberPrinter());
	}

}
