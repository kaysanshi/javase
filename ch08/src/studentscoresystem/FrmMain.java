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
        setTitle("ѧ���ɼ�����ϵͳ");
        mnuSystem.setText("ϵͳ����");
        mnuPower.setText("�û�Ȩ�޹���");
        mnuInfoEdit.setText("��Ϣά��");
        mnuInfoQuery.setText("��Ϣ��ѯ");
        mnuPersonal.setText("������Ϣά��");
        mnuPersonal.addActionListener(new FrmMain_mnuPersonal_actionAdapter(this));
        mnuPwd.setText("�����޸�");
        mnuPwd.addActionListener(new FrmMain_mnuPwd_actionAdapter(this));
        mnuCourseQuery.setText("�γ���Ϣ��ѯ");
        mnuScoreQuery.setText("�ɼ���Ϣ��ѯ");
        mnuScoreQuery.addActionListener(new FrmMain_mnuScoreQuery_actionAdapter(this));
        mnuPwdReset.setText("�û���������");
        mnuUsers.setText("�û��˺�ά��");
        mnuCourse.setText("�γ���Ϣά��");
        mnuClass.setText("�༶��Ϣά��");
        mnuStudent.setText("ѧ����Ϣά��");
        mnuScore.setText("�ɼ���Ϣά��");
        mnuDatabase.setText("���ݿ�ά��");
        mnuTeacher.setText("��ʦ��Ϣά��");
        mnuStudentQuery.setText("ѧ����Ϣ��ѯ");
        mnuClassQuery.setText("�༶��Ϣ��ѯ");
        mnuTeacherQuery.setText("��ʦ��Ϣ��ѯ");
        mnuExit.setText("�˳�ϵͳ");
        mnuHelp.setText("����");
        mnuUserQuery.setText("�û���Ϣ��ѯ");
        mnuLogoff.setText("ע��ϵͳ");
        lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUser.setText("��ӭ�㣬" + FrmLogin.userName);
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
