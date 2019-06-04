package studentscoresystem;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import info.*;
import java.awt.Color;
import java.awt.SystemColor;

public class FrmMain extends JFrame {
    JPanel contentPane;
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu mnuSystem = new JMenu();
    JMenuItem mnuPower = new JMenuItem();
    JMenu mnuInfoEdit = new JMenu();
    JMenu mnuInfoQuery = new JMenu();
    JMenuItem mnuPersonal = new JMenuItem();
    JMenuItem mnuPwd = new JMenuItem();
    JMenuItem mnuCourseQuery = new JMenuItem();
    JMenuItem mnuScoreQuery = new JMenuItem();
    JMenuItem mnuPwdReset = new JMenuItem();
    JMenuItem mnuUsers = new JMenuItem();
    JMenuItem mnuCourse = new JMenuItem();
    JMenuItem mnuClass = new JMenuItem();
    JMenuItem mnuStudent = new JMenuItem();
    JMenuItem mnuScore = new JMenuItem();
    JMenuItem mnuDatabase = new JMenuItem();
    JMenuItem mnuTeacher = new JMenuItem();
    JMenuItem mnuStudentQuery = new JMenuItem();
    JMenuItem mnuClassQuery = new JMenuItem();
    JMenuItem mnuTeacherQuery = new JMenuItem();
    JMenuItem mnuExit = new JMenuItem();
    JMenu mnuHelp = new JMenu();
    JMenuItem mnuUserQuery = new JMenuItem();
    JMenuItem mnuLogoff = new JMenuItem();
    JLabel lblUser = new JLabel();
    public FrmMain() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);
        this.setJMenuBar(jMenuBar1);
        setSize(new Dimension(800, 700));
        setTitle("学生成绩管理系统");
        mnuSystem.setText("系统管理");
        mnuPower.setText("用户权限管理");
        mnuInfoEdit.setText("信息维护");
        mnuInfoQuery.setText("信息查询");
        mnuPersonal.setText("个人信息维护");
        mnuPersonal.addActionListener(new FrmMain_mnuPersonal_actionAdapter(this));
        mnuPwd.setText("密码修改");
        mnuPwd.addActionListener(new FrmMain_mnuPwd_actionAdapter(this));
        mnuCourseQuery.setText("课程信息查询");
        mnuScoreQuery.setText("成绩信息查询");
        mnuScoreQuery.addActionListener(new FrmMain_mnuScoreQuery_actionAdapter(this));
        mnuPwdReset.setText("用户密码重置");
        mnuUsers.setText("用户账号维护");
        mnuCourse.setText("课程信息维护");
        mnuClass.setText("班级信息维护");
        mnuStudent.setText("学生信息维护");
        mnuScore.setText("成绩信息维护");
        mnuDatabase.setText("数据库维护");
        mnuTeacher.setText("教师信息维护");
        mnuStudentQuery.setText("学生信息查询");
        mnuClassQuery.setText("班级信息查询");
        mnuTeacherQuery.setText("教师信息查询");
        mnuExit.setText("退出系统");
        mnuHelp.setText("帮助");
        mnuUserQuery.setText("用户信息查询");
        mnuLogoff.setText("注销系统");
        lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUser.setText("欢迎你，" + FrmLogin.userName);
        lblUser.setBounds(new Rectangle(630, 7, 158, 26));
        contentPane.setBackground(UIManager.getColor("inactiveCaptionText"));
        jMenuBar1.add(mnuSystem);
        jMenuBar1.add(mnuInfoEdit);
        jMenuBar1.add(mnuInfoQuery);
        jMenuBar1.add(mnuHelp);
        mnuSystem.add(mnuPower);
        mnuSystem.add(mnuPwdReset);
        mnuSystem.add(mnuUsers);
        mnuSystem.add(mnuDatabase);
        mnuSystem.add(mnuLogoff);
        mnuSystem.add(mnuExit);
        mnuInfoEdit.add(mnuPersonal);
        mnuInfoEdit.add(mnuPwd);
        mnuInfoEdit.add(mnuTeacher);
        mnuInfoEdit.add(mnuClass);
        mnuInfoEdit.add(mnuCourse);
        mnuInfoEdit.add(mnuStudent);
        mnuInfoEdit.add(mnuScore);
        mnuInfoQuery.add(mnuTeacherQuery);
        mnuInfoQuery.add(mnuClassQuery);
        mnuInfoQuery.add(mnuCourseQuery);
        mnuInfoQuery.add(mnuStudentQuery);
        mnuInfoQuery.add(mnuScoreQuery);
        mnuInfoQuery.add(mnuUserQuery);
        contentPane.add(lblUser);
        if (FrmLogin.identity.equals("student") ||
            FrmLogin.identity.equals("teacher")) {
            mnuTeacher.setVisible(false);
            mnuCourse.setVisible(false);
            mnuClass.setVisible(false);
            mnuStudent.setVisible(false);
            mnuScore.setVisible(false);
        }
    }

    public void mnuPersonal_actionPerformed(ActionEvent e) {
        JFrame frame = null;
        if (FrmLogin.identity.equals("student")) {
            frame = new FrmStudent();
        } else if (FrmLogin.identity.equals("teacher")) {
            frame = new FrmTeacher();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2,
                          (screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);
    }

    public void mnuPwd_actionPerformed(ActionEvent e) {
        FrmPassword frame = new FrmPassword();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2,
                          (screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);
    }

    public void mnuScoreQuery_actionPerformed(ActionEvent e) {
        if(FrmLogin.identity.equals("student")){
        	
        }else if(FrmLogin.identity.equals("teacher")){

        }
    }
}


class FrmMain_mnuScoreQuery_actionAdapter implements ActionListener {
    private FrmMain adaptee;
    FrmMain_mnuScoreQuery_actionAdapter(FrmMain adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuScoreQuery_actionPerformed(e);
    }
}


class FrmMain_mnuPwd_actionAdapter implements ActionListener {
    private FrmMain adaptee;
    FrmMain_mnuPwd_actionAdapter(FrmMain adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuPwd_actionPerformed(e);
    }
}


class FrmMain_mnuPersonal_actionAdapter implements ActionListener {
    private FrmMain adaptee;
    FrmMain_mnuPersonal_actionAdapter(FrmMain adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mnuPersonal_actionPerformed(e);
    }
}
