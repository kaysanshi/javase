package com.qq.client.model;

import com.qq.common.User;
//�����ӵ��������������ͻ������ӵ�λ������
public class QQClientUser {
	//��֤�û�
	public boolean CheckUser(User u) {
		return new QQClient().sendLoginToSrever(u);
	}

}
