package info;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Font;
import studentscoresystem.*;
import users.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmStudent extends JFrame {
    JPanel contentPane;
    JLabel lblID = new JLabel();
    JLabel lblName = new JLabel();
    JRadioButton radMan = new JRadioButton();
    JRadioButton radWoman = new JRadioButton();
    JLabel lblSex = new JLabel();
    JLabel lblBirth = new JLabel();
    JTextField txtBirth = new JTextField();
    JLabel lblPhone = new JLabel();
    JTextField txtPhone = new JTextField();
    JLabel lblEmail = new JLabel();
    JTextField txtEmail = new JTextField();
    JLabel lblMajor = new JLabel();
    JComboBox cboMajor = new JComboBox();
    JLabel lblClass = new JLabel();
    JComboBox cboClass = new JComboBox();
    JButton btnSave = new JButton();
    JButton btnSubmit = new JButton();
    Vector vStu = new Vector();
    Vector vMajor = new Vector();
    Vector vClass = new Vector();
    ButtonGroup btngrpSex = new ButtonGroup();
    Student stu;
    public FrmStudent() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);
        setSize(new Dimension(445, 334));
        setTitle("个人信息维护");
        lblID.setText("学号：");
        lblID.setBounds(new Rectangle(30, 19, 150, 16));
        lblID.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblName.setText("姓名：");
        lblName.setBounds(new Rectangle(236, 19, 150, 16));
        lblName.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        radMan.setText("男");
        radMan.setBounds(new Rectangle(72, 62, 52, 25));
        radMan.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        radWoman.setText("女");
        radWoman.setBounds(new Rectangle(127, 62, 51, 25));
        radWoman.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblSex.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblSex.setText("性别：");
        lblSex.setBounds(new Rectangle(30, 66, 46, 16));
        lblBirth.setText("生日：");
        lblBirth.setBounds(new Rectangle(236, 66, 42, 15));
        lblBirth.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        txtBirth.setBounds(new Rectangle(274, 64, 142, 20));
        txtBirth.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblPhone.setText("电话：");
        lblPhone.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblPhone.setBounds(new Rectangle(30, 118, 42, 15));
        txtPhone.setBounds(new Rectangle(70, 116, 142, 20));
        txtPhone.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblEmail.setText("电邮：");
        lblEmail.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblEmail.setBounds(new Rectangle(236, 118, 42, 15));
        txtEmail.setBounds(new Rectangle(275, 116, 142, 20));
        lblEmail.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblMajor.setText("专业：");
        lblMajor.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblMajor.setBounds(new Rectangle(30, 170, 42, 15));
        cboMajor.setBounds(new Rectangle(70, 167, 142, 23));
        cboMajor.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblClass.setText("班级：");
        lblClass.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblClass.setBounds(new Rectangle(236, 170, 42, 15));
        cboClass.setBounds(new Rectangle(275, 167, 142, 23));
        cboClass.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        btnSave.setBounds(new Rectangle(252, 232, 81, 23));
        btnSave.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        btnSave.setText("保存");
        btnSave.addActionListener(new FrmStudent_btnSave_actionAdapter(this));
        btnSubmit.setBounds(new Rectangle(337, 232, 81, 23));
        btnSubmit.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        btnSubmit.setText("提交");
        btnSubmit.addActionListener(new FrmStudent_btnSubmit_actionAdapter(this));
        contentPane.add(lblSex);
        contentPane.add(lblPhone);
        contentPane.add(txtPhone);
        contentPane.add(radWoman);
        contentPane.add(radMan);
        contentPane.add(lblID);
        contentPane.add(cboMajor);
        contentPane.add(lblMajor);
        contentPane.add(txtBirth);
        contentPane.add(cboClass);
        contentPane.add(txtEmail);
        contentPane.add(lblClass);
        contentPane.add(lblName);
        contentPane.add(lblBirth);
        contentPane.add(lblEmail);
        contentPane.add(btnSubmit);
        contentPane.add(btnSave);
        btngrpSex.add(radMan);
        btngrpSex.add(radWoman);
        vMajor = DBCon.getData("Select * from Major");
        for (int i = 0; i < vMajor.size(); i++) {
            Vector v = (Vector) vMajor.get(i);
            cboMajor.addItem(v.get(1).toString());
        }
        vClass = DBCon.getData("Select * from Classes");
        for (int i = 0; i < vClass.size(); i++) {
            Vector v = (Vector) vClass.get(i);
            cboClass.addItem(v.get(1).toString());
        }
        showData();
    }

    void showData() {
        vStu = DBCon.getData(FrmLogin.uid, FrmLogin.identity);
        stu = new Student(vStu.get(0).toString(), vStu.get(1).toString(),
                          vStu.get(2).toString(), vStu.get(3).toString(),
                          vStu.get(4).toString(), vStu.get(5).toString(),
                          vStu.get(6).toString(), vStu.get(7).toString(),
                          vStu.get(8).toString());
        lblID.setText("学号：" + stu.getId());
        lblName.setText("姓名：" + stu.getName());
        if (stu.getSex().equals("男")) {
            radMan.setSelected(true);
        } else {
            radWoman.setSelected(true);
        }
        txtBirth.setText(stu.getBirth().substring(0, 10));
        txtPhone.setText(stu.getPhone());
        txtEmail.setText(stu.getEmail());
        Vector vm = DBCon.getData(vStu.get(7).toString(), "major");
        cboMajor.setSelectedItem(vm.get(1).toString());
        Vector vc = DBCon.getData(vStu.get(8).toString(), "classes");
        cboClass.setSelectedItem(vc.get(1).toString());
        int status = Integer.parseInt(vStu.get(9).toString());
        if (status == 0) {
            lockText();
        } else {
            unlockText();
        }
    }

    public void btnSave_actionPerformed(ActionEvent e) {
        String sex = "";
        if (radMan.isSelected()) {
            sex = "男";
        } else {
            sex = "女";
        }
        String birth = txtBirth.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String major = cboMajor.getSelectedItem().toString();
        String classes = cboClass.getSelectedItem().toString();
        String majorID = DBCon.getID("Select * from Major where majorName='" +
                                     major + "'");
        String classesID = DBCon.getID(
                "Select * from Classes where className='" + classes + "'");
        String sql = "update Student set sex='" + sex + "',birth='" +
                     birth + "',phone='" + phone + "',email='" + email +
                     "',majorID='" + majorID + "',classesID='" + classesID +
                     "' where studentID='" + stu.getId() + "'";
        System.out.println(sql);
        if (DBCon.updateData(sql)) {
            btnSubmit.setEnabled(true);
            JOptionPane.showMessageDialog(null, "保存成功", "系统提示",
                                          JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "保存失败", "系统提示",
                                          JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnSubmit_actionPerformed(ActionEvent e) {
        String sql = "update Student set status=0 where studentID='" +
                     stu.getId() + "'";
        System.out.println(sql);
        if (DBCon.updateData(sql)) {
            lockText();
            JOptionPane.showMessageDialog(null, "提交成功", "系统提示",
                                          JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "提交失败", "系统提示",
                                          JOptionPane.ERROR_MESSAGE);
        }
    }

    void lockText() {
        radMan.setEnabled(false);
        radWoman.setEnabled(false);
        txtBirth.setEnabled(false);
        txtPhone.setEnabled(false);
        txtEmail.setEnabled(false);
        cboMajor.setEnabled(false);
        cboClass.setEnabled(false);
        btnSave.setEnabled(false);
        btnSubmit.setEnabled(false);
    }

    void unlockText() {
        radMan.setEnabled(true);
        radWoman.setEnabled(true);
        txtBirth.setEnabled(true);
        txtPhone.setEnabled(true);
        txtEmail.setEnabled(true);
        cboMajor.setEnabled(true);
        cboClass.setEnabled(true);
        btnSave.setEnabled(true);
    }

}


class FrmStudent_btnSubmit_actionAdapter implements ActionListener {
    private FrmStudent adaptee;
    FrmStudent_btnSubmit_actionAdapter(FrmStudent adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSubmit_actionPerformed(e);
    }
}


class FrmStudent_btnSave_actionAdapter implements ActionListener {
    private FrmStudent adaptee;
    FrmStudent_btnSave_actionAdapter(FrmStudent adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSave_actionPerformed(e);
    }
}
