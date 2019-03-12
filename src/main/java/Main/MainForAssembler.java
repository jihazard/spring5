package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;import org.hibernate.WrongClassException;

import assembler.Assembler;
import javassist.bytecode.DuplicateMemberException;
import spring.ChangePasswordService;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.WrongPasswortException;

public class MainForAssembler {
		public static void main(String[] args ) throws IOException {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			while(true){
				System.out.println("명령어를 입려하세요 ");
				String command = reader.readLine();
				
				if(command.equalsIgnoreCase("exit")){
					System.out.println("종료합니다.");
					break;
				}
				if(command.startsWith("new ")){
					processNewCommand(command.split(" "));
					continue;
				}
				else if(command.startsWith("change ")){
					processChangeCommand(command.split(" "));
					continue;
				}
				printHelp();
				
			}
		}
		
		private static Assembler assembler = new Assembler();

		private static void processNewCommand(String[] args) {
			// TODO Auto-generated method stub
			if(args.length != 5) {
				printHelp();
				return;
			}
			
			MemberRegisterService regService = assembler.getRegService();
			RegisterRequest req = new RegisterRequest();
			req.setEmail(args[1]);
			req.setName(args[2]);
			req.setPassword(args[3]);
			req.setConfirmPassword(args[4]);
			
			if(!req.isPassswordEqualsToConfirmPassword()){
				
			System.out.println("암호확인이 일치하지 않음");
				return;
			} 
			
			try{
				regService.register(req);
				System.out.println("등록성공");
			}catch(DuplicateMemberException e){
				System.out.println("이미 존재하는 이메일임 " + e);
			}
			
		}
		
		private static void processChangeCommand(String[] args) {
			if(args.length != 4) {
				printHelp();
				return;
			}
			
			ChangePasswordService changeService = assembler.getPassService();
			
			try {
				changeService.changePassword(args[1], args[2], args[3]);
				System.out.println("암호 변경 완료");
			} catch (MemberNotFoundException  e) {
				// TODO: handle exception
				System.out.println("존재하지 않는 이메일입니다. " + e);
			} catch (WrongPasswortException e) {
				// TODO: handle exception
				System.out.println("일치하지 않는 암호입니다." + e);
			}
		}

		private static void printHelp() {
			// TODO Auto-generated method stub
			System.out.println(" 암호확인해주세요  잘못된 암호입니다 printHelp \n");
		}
		
		
}
