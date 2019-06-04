package info;

import java.awt.*;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Dimension;
import studentscoresystem.DBCon;
import studentscoresystem.FrmLogin;
import java.util.*;
import users.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPassword extends JFrame {
    JPanel contenPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JLabel lblOldPwd = new JLabel();
    JPasswordField pwdOld = new JPasswordField();
    JLabel lblNewPwd = new JLabel();
    JPasswordField pwdNew = new JPasswordField();
    JLabel lblNewPwd2 = new JLabel();
    JPasswordField pwdNew2 = new JPasswordField();
    JLabel lblID = new JLabel();
    JTextField txtID = new JTextField();
    JButton btnOk = new JButton();
    Vector vData = new Vector();

    public FrmPassword() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        contenPane = (JPanel) getContentPane();
        contenPane.setLayout(null);
        setSize(new Dimension(333, 280));
        setTitle("个人密码修改");
        lblID.setText("用户名：");
        lblID.setBounds(new Rectangle(50, 30, 90, 20));
        lblID.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        txtID.setEnabled(false);
        txtID.setBounds(new Rectangle(132, 30, 132, 24));
        txtID.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblOldPwd.setText("旧密码：");
        lblOldPwd.setBounds(new Rectangle(50, 70, 90, 20));
        lblOldPwd.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        pwdOld.setBounds(new Rectangle(132, 70, 132, 24));
        pwdOld.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblNewPwd.setText("新密码：");
        lblNewPwd.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblNewPwd.setBounds(new Rectangle(50, 110, 90, 18));
        pwdNew.setBounds(new Rectangle(132, 110, 132, 24));
        pwdNew.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblNewPwd2.setText("确认新密码：");
        lblNewPwd2.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblNewPwd2.setBounds(new Rectangle(50, 150, 90, 19));
        pwdNew2.setBounds(new Rectangle(132, 150, 132, 24));
        pwdNew2.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        btnOk.setBounds(new Rectangle(128, 204, 81, 23));
        btnOk.setText("确定");
        btnOk.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        btnOk.addActionListener(new FrmPassword_btnOk_actionAdapter(this));
        contenPane.add(lblOldPwd);
        contenPane.add(pwdOld);
        contenPane.add(lblNewPwd);
        contenPane.add(pwdNew);
        contenPane.add(lblNewPwd2);
        contenPane.add(pwdNew2);
        contenPane.add(txtID);
        contenPane.add(lblID);
        contenPane.add(btnOk);
        showData();
    }

    void showData() {
        vData = DBCon.getData(FrmLogin.uid, FrmLogin.identity);
        Users user = new Users(FrmLogin.uid, FrmLogin.oldPassword);
        txtID.setText(FrmLogin.uid);
    }

    public void btnOk_actionPerformed(ActionEvent e) {
        String oldPassword = new String(pwdOld.getPassword());
        String newPassword = new String(pwdNew.getPassword());
        String newPassword2 = new String(pwdNew2.getPassword());
        if (oldPassword.length() == 0) {
            JOptionPane.showMessageDialog(null, "旧密码必填", "错误",
                                          JOptionPane.ERROR_MESSAGE);
            pwdOld.requestFocus();
            return;
        }
        if (newPassword.length() == 0) {
            JOptionPane.showMessageDialog(null, "新密码必填", "错误",
                                          JOptionPane.ERROR_MESSAGE);
            pwdNew.requestFocus();
            return;
        }
        if (newPassword2.length() == 0) {
            JOptionPane.showMessageDialog(null, "确认新密码必填", "错误",
                                          JOptionPane.ERROR_MESSAGE);
            pwdNew2.requestFocus();
            return;
        }
        if (!oldPassword.equals(FrmLogin.oldPassword)) {
            JOptionPane.showMessageDialog(null, "旧密码错误，请重新输入", "错误",
                                          JOptionPane.ERROR_MESSAGE);
            pwdOld.requestFocus();
            pwdOld.selectAll();
            return;
        }
        if (newPassword.length() < 6) {
            JOptionPane.showMessageDialog(null, "新密码位数不得少于6位，请重新输入", "错误",
                                          JOptionPane.ERROR_MESSAGE);
            pwdNew.requestFocus();
            pwdNew.setText("");
            return;
        }
        if (!newPassword.equals(newPassword2)) {
            JOptionPane.showMessageDialog(null, "确认新密码和新密码不一致，请重新输入", "错误",
                                          JOptionPane.ERROR_MESSAGE);
            pwdNew.requestFocus();
            pwdNew.setText("");
            pwdNew2.setText("");
            return;
        }
        String sql = "update " + FrmLogin.identity + " set password='" +
                     newPassword + "' where " + FrmLogin.identity + "ID='" +
                     FrmLogin.uid + "'";
        System.out.println(sql);
        if(DBCon.updateData(sql)){
            JOptionPane.showMessageDialog(null, "修改密码成功", "系统提示",
                                          JOptionPane.INFORMATION_MESSAGE);
        }
    }
}


class FrmPassword_btnOk_actionAdapter implements ActionListener {
    private FrmPassword adaptee;
    FrmPassword_btnOk_actionAdapter(FrmPassword adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnOk_actionPerformed(e);
    }
}
