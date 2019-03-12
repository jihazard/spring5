package spring;

import java.time.LocalDateTime;

public class Member {
		private Long id;
		private String email;
		private String password;
		private String name;
		private LocalDateTime regDataTime;
		
		public Member(String email, String password, String name, LocalDateTime regDataTime) {
			this.email = email;
			this.password = password;
			this.name = name;
			this.regDataTime = regDataTime;
		}
		
		
		
		public void setId(Long id) {
			this.id = id;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public void setName(String name) {
			this.name = name;
		}



		public void setRegDataTime(LocalDateTime regDataTime) {
			this.regDataTime = regDataTime;
		}



		public Long getId() {
			return id;
		}

		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}

		public String getName() {
			return name;
		}

		public LocalDateTime getRegDataTime() {
			return regDataTime;
		}
		
		public void changePassword(String oldPw , String newPw){
			if(!password.equals(oldPw)){
				try {
					throw new WrongPasswortException();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			this.password=newPw;
		}
		
		
}
