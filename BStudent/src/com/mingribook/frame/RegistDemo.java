package com.mingribook.frame;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import com.mingribook.util.UserUtil;

public class RegistDemo extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7774133711807576073L;
    private JPanel contentPane;
    private JTextField uname;
    private JPasswordField pwd1;
    
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
                    RegistDemo frame = new RegistDemo();
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
    public RegistDemo() {
        setTitle("\u7528\u6237\u767B\u5F55");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 311, 189);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(4, 1, 5, 5));
        
        JPanel panel = new JPanel();
        contentPane.add(panel);
        
        JLabel lblmrmrsoft = new JLabel("\u7BA1\u7406\u5458\u8D26\u53F7\uFF1Amr \u5BC6\u7801\uFF1Amrsoft");
        panel.add(lblmrmrsoft);
        
        JPanel panel1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel1.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel1);
        
        JLabel label1 = new JLabel("\u7528  \u6237  \u540D\uFF1A");
        panel1.add(label1);
        
        uname = new JTextField();
        panel1.add(uname);
        uname.setColumns(18);
        
        JPanel panel2 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel2.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel2);
        
        JLabel label2 = new JLabel("\u5BC6      \u7801\uFF1A");
        panel2.add(label2);
        
        pwd1 = new JPasswordField();
        pwd1.setColumns(18);
        panel2.add(pwd1);
        
        JPanel panel4 = new JPanel();
        contentPane.add(panel4);
        
        JButton button2 = new JButton("\u767B\u5F55");
        button2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		do_button2_actionPerformed(e);
        	}
        });
       
        panel4.add(button2);
        
        JButton button3 = new JButton("\u6CE8\u518C");
        button3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		do_button3_actionPerformed(e);
        	}
        });
        panel4.add(button3);
    }
	
	protected void do_button2_actionPerformed(ActionEvent e) {
		UserDao dao=new UserDao();
		int i=dao.loginuser(uname.getText(), pwd1.getText());
		if(i==3){
			JOptionPane.showMessageDialog(this, "µÇÂ¼Ê§°Ü", "",
					JOptionPane.WARNING_MESSAGE);
			return;
		}else{
			UserUtil u=new UserUtil();
			u.setPopedom(i);
			SelectFrame sf=new SelectFrame();
			sf.setVisible(true);
			this.setVisible(false);
		}
	}
	protected void do_button3_actionPerformed(ActionEvent e) {
		AddFrame add=new AddFrame();
		add.setVisible(true);
		this.setVisible(false);
	}
}
