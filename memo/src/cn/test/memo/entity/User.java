package cn.test.memo.entity;

public class User {
	private Integer id;
	private String nick;
	private String username;
	private String password;
	private String last_login_time;
	private String last_login_ip;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(String last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getLast_login_ip() {
		return last_login_ip;
	}
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nick=" + nick + ", username=" + username + ", password=" + password
				+ ", last_login_time=" + last_login_time + ", last_login_ip=" + last_login_ip + "]";
	}
}	
