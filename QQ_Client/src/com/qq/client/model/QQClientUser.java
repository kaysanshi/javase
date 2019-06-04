package com.qq.client.model;

import com.qq.common.User;
//和连接的类就是与服务器客户端连接的位界面用
public class QQClientUser {
	//验证用户
	public boolean CheckUser(User u) {
		return new QQClient().sendLoginToSrever(u);
	}

}
