package service;
//����ļ����ϴ������ļ�����Ϣ�Լ������ʼ�ʱ�����ļ����صĴ�����ͨ�÷���

import java.util.Map;

import util.DButils;

public class CommonService {
	private DButils db=new DButils();
	//��ȡ�����ļ���map����
	public  Map getDownLoadFile(String id){
		String sql="select filePath,fileName from files where id=?";
		return db.getMap(sql, new String[]{id});
	}
	//�ϴ��ļ��Ĵ�����
	public void updateHits(String id){
		String sql="update files set hit=hits+1 where id=?";
		db.update(sql, new String[]{id});
	}
}
