package com.zcib2.job1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class MoiveSerializableTest {
	public static void main(String[] args) {
		Moive moive=new Moive(MoiveType.ð��Adventure);
		MoiveSeat mSeat=new MoiveSeat();
		MoiveSchedule mSchedule=new MoiveSchedule();	
			moive.setName("����ʯͷ");
			mSchedule.setDate("2012��10��29��");
			mSchedule.setMovienumber("Ӱ��һ");
			mSeat.setRow("10��");
			mSeat.setSeat("15��");
		Moive moive1=new Moive(MoiveType.����Romance);
		MoiveSeat mSeat1=new MoiveSeat();
		MoiveSchedule mSchedule1=new MoiveSchedule();	
			moive1.setName("ҹ����");
			mSchedule1.setDate("2012��10��29��");
			mSchedule1.setMovienumber("Ӱ����");
			mSeat1.setRow("19��");
			mSeat1.setSeat("25��");
		Moive moive2=new Moive(MoiveType.����Romance);
		MoiveSeat mSeat2=new MoiveSeat();
		MoiveSchedule mSchedule2=new MoiveSchedule();	
			moive2.setName("ҹ����2");
			mSchedule2.setDate("2013��10��10��");
			mSchedule2.setMovienumber("Ӱ����");
			mSeat2.setRow("20��");
			mSeat2.setSeat("25��");
		// TODO Auto-generated method stub
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		MoiveTicket mTicket=new MoiveTicket(moive,mSeat,mSchedule);
		MoiveTicket mTicket1=new MoiveTicket(moive1,mSeat1,mSchedule1);
		MoiveTicket mTicket2=new MoiveTicket(moive2,mSeat2,mSchedule2);
		try {
			fos=new FileOutputStream("E:\\IoDemoforJava\\File1.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(mTicket);
			oos.writeObject(mTicket1);
			oos.writeObject(mTicket2);
			fis=new FileInputStream("E:\\IoDemoforJava\\File1.txt");
			ois=new ObjectInputStream(fis);
			MoiveTicket s1_s=(MoiveTicket)ois.readObject();
			MoiveTicket s2_s=(MoiveTicket)ois.readObject();
			MoiveTicket s3_s=(MoiveTicket)ois.readObject();
			s1_s.printTicket();
			
			System.out.println("-------------------");
			s2_s.printTicket();
			System.out.println("-------------------");
			s3_s.printTicket();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
