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
				throw new MsgException("用户名不能为空!");
			}
			if(passward==null || "".equals(passward)){
				throw new MsgException("密码不能为空!");
			}
			if(passward2==null || "".equals(passward2)){
				throw new MsgException("确认密码不能为空!");
			}
			if(!passward.equals(passward2)){
				throw new MsgException("两次密码不一致!");
			}
			if(nickname==null || "".equals(nickname)){
				throw new MsgException("昵称不能为空!");
			}
			if(email==null || "".equals(email)){
				throw new MsgException("邮箱不能为空!");
			}
			if(!email.matches("^\\w+@\\w+(\\.\\w+)+$")){
				throw new MsgException("邮箱格式不正确!");
			}
		}
		
}
