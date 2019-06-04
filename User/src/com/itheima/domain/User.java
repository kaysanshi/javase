package com.itheima.domain;

import java.io.Serializable;

import com.ithiema.exception.MsgException;

public class User implements Serializable{
		private String username;
		private String passward;
		private String passward2;
		private String nickname;
		private String email;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassward() {
			return passward;
		}
		public void setPassward(String passward) {
			this.passward = passward;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassward2() {
			return passward2;
		}
		public void setPassward2(String passward2) {
			this.passward2 = passward2;
		}
		
		public void checkValue() throws MsgException{
			if(username==null || "".equals(username)){
				throw new MsgException("�û�������Ϊ��!");
			}
			if(passward==null || "".equals(passward)){
				throw new MsgException("���벻��Ϊ��!");
			}
			if(passward2==null || "".equals(passward2)){
				throw new MsgException("ȷ�����벻��Ϊ��!");
			}
			if(!passward.equals(passward2)){
				throw new MsgException("�������벻һ��!");
			}
			if(nickname==null || "".equals(nickname)){
				throw new MsgException("�ǳƲ���Ϊ��!");
			}
			if(email==null || "".equals(email)){
				throw new MsgException("���䲻��Ϊ��!");
			}
			if(!email.matches("^\\w+@\\w+(\\.\\w+)+$")){
				throw new MsgException("�����ʽ����ȷ!");
			}
		}
		
}
