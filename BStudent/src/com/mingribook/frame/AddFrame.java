package com.mingribook.frame;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mingribook.dao.*;
import com.mingribook.db.DbTools;

public class AddFrame extends JFrame{
    
    /**
     * 搞不懂;;;;;;
     */
    private static final long serialVersionUID = -7774133711807576073L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField pwd1;
    private JPasswordField pwd2;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddFrame frame = new AddFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public AddFrame() {
        setTitle("\u65B0\u7528\u6237\u6CE8\u518C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 311, 219);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(4, 1, 5, 5));
        
        JPanel panel1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel1.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel1);
        
        JLabel label1 = new JLabel("\u7528  \u6237  \u540D\uFF1A");
        panel1.add(label1);
        
        textField = new JTextField();
        panel1.add(textField);
        textField.setColumns(15);
        
        JPanel panel2 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel2.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel2);
        
        JLabel label2 = new JLabel("\u8F93\u5165\u5BC6\u7801\uFF1A");
        panel2.add(label2);
        
        pwd1 = new JPasswordField();
        pwd1.setColumns(18);
        panel2.add(pwd1);
        
        JPanel panel3 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel3.getLayout();
        flowLayout_2.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel3);
        
        JLabel label3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
        panel3.add(label3);
        
        pwd2 = new JPasswordField();
        pwd2.setColumns(18);
        panel3.add(pwd2);
        
        JPanel panel4 = new JPanel();
        contentPane.add(panel4);
        
        JButton button2 = new JButton("\u63D0\u4EA4");
        button2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		do_button2_actionPerformed(e);
        	}
        });
        panel4.add(button2);
        
        JButton button3 = new JButton("\u8FD4\u56DE");
        button3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		do_button3_actionPerformed(e);
        	}
        });
        panel4.add(button3);
    }
	protected void do_button2_actionPerformed(ActionEvent e) {
		String sql = "select * from tb_login where username = '" +textField.getText()+ "';";
		DbTools db=new DbTools();
		Connection conn=db.getConn();
		ResultSet rs= null;
		try {
			Statement st=conn.createStatement();
			rs=st.executeQuery(sql);
			if (!rs.next()) {
	            if(pwd1.getText().equals(pwd2.getText())){
	    			UserDao dao=new UserDao();
	    			dao.addUser(textField.getText(), pwd1.getText());
	    			JOptionPane.showMessageDialog(this, "注册成功！", null, JOptionPane.INFORMATION_MESSAGE);
	    			this.setVisible(false);
	    			RegistDemo r=new RegistDemo();
	    			r.setVisible(true);
	    		}else{
	    			JOptionPane.showMessageDialog(this, "两次密码不一致！", null, JOptionPane.INFORMATION_MESSAGE);
		            return;
	    		}
			} else {
	            JOptionPane.showMessageDialog(this, "用户名冲突！", null, JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	protected void do_button3_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		RegistDemo r=new RegistDemo();
		r.setVisible(true);
	}
}
