package studentscoresystem;

import users.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class FrmLogin extends JFrame {
    JPanel contenPane;
    JTextField txtUser = new JTextField();
    JPasswordField pwd = new JPasswordField();
    JButton btnLogin = new JButton();
    JButton btnReset = new JButton();
    public static String uid;
    public static String userName;
    public static String oldPassword;
    public static String identity;
    JLabel lblBkg = new JLabel();
    ImageIcon icon1 = new ImageIcon(".\\images\\loginBkg.jpg");
    ImageIcon icon2 = new ImageIcon(".\\images\\imgBtnLogin.jpg");
    ImageIcon icon3 = new ImageIcon(".\\images\\imgBtnReset.jpg");
    int count = 0;
    public FrmLogin() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        contenPane = (JPanel) getContentPane();
        contenPane.setLayout(null);
        setSize(new Dimension(407, 267));
        setTitle("学生成绩管理系统登录");
        txtUser.setBounds(new Rectangle(175, 76, 155, 21));
        txtUser.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        pwd.setBounds(new Rectangle(175, 114, 155, 21));
        pwd.addKeyListener(new FrmLogin_pwd_keyAdapter(this));
        pwd.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        btnLogin.setBounds(new Rectangle(147, 170, 63, 25));
        btnLogin.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        btnLogin.setText("");
        btnLogin.setIcon(icon2);
        btnLogin.addActionListener(new FrmLogin_btnLogin_actionAdapter(this));
        btnReset.setBounds(new Rectangle(227, 170, 63, 25));
        btnReset.setIcon(icon3);
        btnReset.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblBkg.setBounds(new Rectangle(0, 0, 408, 267));
        lblBkg.setOpaque(true);
        lblBkg.setIcon(icon1);
        contenPane.add(txtUser);
        contenPane.add(pwd);
        contenPane.add(btnReset);
        contenPane.add(btnLogin);
        contenPane.add(lblBkg);
    }

    public void btnLogin_actionPerformed(ActionEvent e) {
        String id = txtUser.getText();
        String password = new String(pwd.getPassword());
        if (id.length() == 0) {
            JOptionPane.showMessageDialog(null, "用户名不能为空，请输入", "登录错误",
                                          JOptionPane.ERROR_MESSAGE);
            txtUser.requestFocus();
            return;
        }
        if (password.length() == 0) {
            JOptionPane.showMessageDialog(null, "密码不能为空，请输入", "登录错误",
                                          JOptionPane.ERROR_MESSAGE);
            pwd.requestFocus();
            return;
        }
        if (!id.matches("[0-9]*")) {
            JOptionPane.showMessageDialog(null, "用户名是学号或教工号，必须是数字", "登录错误",
                                          JOptionPane.ERROR_MESSAGE);
            txtUser.requestFocus();
            txtUser.selectAll();
            return;
        }
        Users user = new Users(id, password);
        if (DBCon.validateUser(id)) {
            if (id.length() >= DBCon.IDNUM) {
                identity = "student";
            } else {
                identity = "teacher";
            }
            Vector data = DBCon.getData("select active from " + identity +
                                        " where " + identity + "ID='" + id +
                                        "'");
            Vector line = (Vector) data.get(0);
            String active = line.get(0).toString();
            if (active.equals("0")) {
                JOptionPane.showMessageDialog(null,
                                              "该用户已经被锁定，请与系统管理员联系",
                                              "系统提示",
                                              JOptionPane.INFORMATION_MESSAGE);
                pwd.setText("");
                txtUser.setText("");
                txtUser.requestFocus();
                return;
            }

            if (DBCon.validatePwd(user)) {
                Vector vData = DBCon.getData(id, identity);
                uid = id;
                oldPassword = password;
                userName = vData.get(1).toString();
                FrmMain frame = new FrmMain();
                Dimension screenSize = Toolkit.getDefaultToolkit().
                                       getScreenSize();
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
                this.dispose();
            } else {
                count++;
                if (count >= 3) {
                    DBCon.updateData("update " + identity +
                                     " set active=0 where " + identity + "id='" +
                                     id + "'");
                    JOptionPane.showMessageDialog(null,
                                                  "密码错误次数太多，该用户已经被锁定，请与系统管理员联系",
                                                  "系统提示",
                                                  JOptionPane.ERROR_MESSAGE);
                    pwd.setText("");
                    txtUser.setText("");
                    txtUser.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误"+count+"次", "登录错误",
                                                  JOptionPane.ERROR_MESSAGE);
                    pwd.requestFocus();
                    pwd.selectAll();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "用户名错误", "登录错误",
                                          JOptionPane.ERROR_MESSAGE);
            txtUser.requestFocus();
            txtUser.selectAll();
        }
    }

    public void pwd_keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            btnLogin_actionPerformed(null);
        }
    }
}


class FrmLogin_pwd_keyAdapter extends KeyAdapter {
    private FrmLogin adaptee;
    FrmLogin_pwd_keyAdapter(FrmLogin adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
        adaptee.pwd_keyPressed(e);
    }
}


class FrmLogin_btnLogin_actionAdapter implements ActionListener {
    private FrmLogin adaptee;
    FrmLogin_btnLogin_actionAdapter(FrmLogin adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnLogin_actionPerformed(e);
    }
}
