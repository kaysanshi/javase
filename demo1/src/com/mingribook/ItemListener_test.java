package com.mingribook;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 选项事件的使用；内部类的方法使用。
 */
public class ItemListener_test extends JFrame{
	JComboBox jcb;
	JPanel jp;
	public ItemListener_test(){
		jcb=new JComboBox();
		jp=new JPanel();
		for(int i=1;i<6;i++){
			jcb.addItem("选项"+i);
		}
		//添加选项事件的监听器
		jcb.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//获取此事件的类型然后在令与静态常量对比；
				int stateChange=e.getStateChange();
				String item=e.getItem().toString();//获得此事件的选项
				if(stateChange==ItemEvent.SELECTED){
					System.out.println("此事件由  选中 "+item+"触发");
				}else if(stateChange==ItemEvent.DESELECTED){
					System.out.println("此事件由   取消选中   "+item+"触发");
				}else{
					System.out.println("此事件由其他原因触发");
				}
				
			}
			
		});
		//添加到Jpanel和JFrame中
		jp.add(jcb);
		this.add(jp);
		this.setTitle("选项事件");
		this.setSize(500, 300);
		this.setLocation(200, 300);
		//添加JFrame中的监听事件用于关闭JFrame窗口 ，
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
			ItemListener_test p=new ItemListener_test();
	
		}
}
