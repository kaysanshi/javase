package info;

import java.awt.*;
import users.*;
import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Dimension;
import java.util.Vector;
import studentscoresystem.DBCon;
import users.Student;
import studentscoresystem.FrmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmTeacher extends JFrame {
    JPanel contenPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JButton btnSubmit = new JButton();
    JLabel lblID = new JLabel();
    JLabel lblName = new JLabel();
    JLabel lblMajor = new JLabel();
    JLabel lblBirth = new JLabel();
    JLabel lblSex = new JLabel();
    JTextField txtEmail = new JTextField();
    JRadioButton radMan = new JRadioButton();
    JComboBox cboMajor = new JComboBox();
    JButton btnSave = new JButton();
    JLabel lblPhone = new JLabel();
    JTextField txtPhone = new JTextField();
    JLabel lblEmail = new JLabel();
    JRadioButton radWoman = new JRadioButton();
    JTextField txtBirth = new JTextField();
    ButtonGroup btngrpSex = new ButtonGroup();
    JLabel lblGra = new JLabel();
    JTextField txtGra = new JTextField();
    JLabel lblEdu = new JLabel();
    JTextField txtEdu = new JTextField();
    JLabel lblDuty = new JLabel();
    JTextField txtDuty = new JTextField();
    JLabel lblTitle = new JLabel();
    JTextField txtTitle = new JTextField();
    JLabel lblStudy = new JLabel();
    JTextField txtStudy = new JTextField();
    JLabel lblResume = new JLabel();
    JTextArea txaResume = new JTextArea();
    JScrollPane scp = new JScrollPane();
    Vector vMajor;
    Vector vTeacher;
    Teacher tea = new Teacher();
    public FrmTeacher() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        contenPane = (JPanel) getContentPane();
        contenPane.setLayout(null);
        setSize(new Dimension(522, 560));
        setTitle("个人信息维护");
        lblID.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblID.setText("教工号：");
        lblID.setBounds(new Rectangle(15, 11, 150, 16));
        lblName.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblName.setText("姓名：");
        lblName.setBounds(new Rectangle(260, 12, 150, 16));
        lblSex.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblSex.setText("性别：");
        lblSex.setBounds(new Rectangle(15, 45, 46, 16));
        radMan.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        radMan.setText("男");
        radMan.setBounds(new Rectangle(102, 40, 50, 25));
        radWoman.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        radWoman.setText("女");
        radWoman.setBounds(new Rectangle(157, 40, 50, 25));
        lblBirth.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblBirth.setText("生日：");
        lblBirth.setBounds(new Rectangle(260, 47, 42, 15));
        txtBirth.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        txtBirth.setBounds(new Rectangle(326, 40, 168, 20));
        lblPhone.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblPhone.setText("电话：");
        lblPhone.setBounds(new Rectangle(15, 80, 42, 15));
        txtPhone.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        txtPhone.setBounds(new Rectangle(83, 75, 150, 20));
        lblEmail.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblEmail.setText("电邮：");
        lblEmail.setBounds(new Rectangle(260, 80, 42, 15));
        txtEmail.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        txtEmail.setBounds(new Rectangle(327, 75, 168, 20));
        lblGra.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblGra.setText("毕业学校：");
        lblGra.setBounds(new Rectangle(15, 110, 71, 27));
        txtGra.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        txtGra.setBounds(new Rectangle(83, 111, 150, 20));
        lblEdu.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblEdu.setText("学历：");
        lblEdu.setBounds(new Rectangle(260, 110, 71, 27));
        txtEdu.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        txtEdu.setBounds(new Rectangle(327, 111, 168, 20));
        lblDuty.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblDuty.setText("职务：");
        lblDuty.setBounds(new Rectangle(15, 150, 61, 15));
        txtDuty.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        txtDuty.setBounds(new Rectangle(83, 146, 150, 20));
        lblTitle.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblTitle.setText("职称：");
        lblTitle.setBounds(new Rectangle(260, 150, 61, 15));
        txtTitle.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        txtTitle.setBounds(new Rectangle(327, 146, 168, 20));
        lblMajor.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblMajor.setText("专业：");
        lblMajor.setBounds(new Rectangle(15, 182, 42, 15));
        cboMajor.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        cboMajor.setBounds(new Rectangle(83, 180, 150, 20));
        lblStudy.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblStudy.setText("研究方向：");
        lblStudy.setBounds(new Rectangle(260, 182, 80, 15));
        txtStudy.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        txtStudy.setBounds(new Rectangle(327, 180, 168, 20));
        lblResume.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        lblResume.setText("个人简历：");
        lblResume.setBounds(new Rectangle(15, 216, 72, 21));
        btnSave.setBounds(new Rectangle(328, 494, 81, 23));
        btnSave.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        btnSave.setText("保存");
        btnSave.addActionListener(new FrmTeacher_btnSave_actionAdapter(this));
        btnSubmit.setBounds(new Rectangle(413, 494, 81, 23));
        btnSubmit.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        btnSubmit.setText("提交");
        btnSubmit.addActionListener(new FrmTeacher_btnSubmit_actionAdapter(this));
        scp.setBounds(new Rectangle(15, 239, 480, 245));
        txaResume.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14));
        contenPane.add(cboMajor);
        contenPane.add(lblGra);
        contenPane.add(lblSex);
        contenPane.add(lblPhone);
        contenPane.add(lblID);
        contenPane.add(txtPhone);
        contenPane.add(txtGra);
        contenPane.add(lblDuty);
        contenPane.add(txtDuty);
        contenPane.add(lblMajor);
        contenPane.add(txtStudy);
        contenPane.add(lblStudy);
        contenPane.add(txtTitle);
        contenPane.add(txtEdu);
        contenPane.add(txtBirth);
        contenPane.add(txtEmail);
        contenPane.add(lblTitle);
        contenPane.add(lblEdu);
        contenPane.add(lblEmail);
        contenPane.add(lblBirth);
        contenPane.add(lblName);
        contenPane.add(lblResume);
        contenPane.add(radWoman);
        contenPane.add(radMan);
        contenPane.add(scp);
        contenPane.add(btnSubmit);
        contenPane.add(btnSave);
        scp.getViewport().add(txaResume);
        btngrpSex.add(radMan);
        btngrpSex.add(radWoman);
        vMajor = DBCon.getData("Select * from Major");
        for (int i = 0; i < vMajor.size(); i++) {
            Vector v = (Vector) vMajor.get(i);
            cboMajor.addItem(v.get(1).toString());
        }
        showData();
    }

    void showData() {
        vTeacher = DBCon.getData(FrmLogin.uid, FrmLogin.identity);
        tea = new Teacher(vTeacher.get(0).toString(), vTeacher.get(1).toString(),
                          vTeacher.get(2).toString(), vTeacher.get(3).toString(),
                          vTeacher.get(4).toString(), vTeacher.get(5).toString(),
                          vTeacher.get(6).toString(), vTeacher.get(7).toString(),
                          vTeacher.get(8).toString(), vTeacher.get(9).toString(),
                          vTeacher.get(10).toString(),
                          vTeacher.get(11).toString(),
                          vTeacher.get(12).toString(),
                          vTeacher.get(13).toString());
        lblID.setText("教工号：" + tea.getId());
        lblName.setText("姓名：" + tea.getName());
        if (tea.getSex().equals("男")) {
            radMan.setSelected(true);
        } else {
            radWoman.setSelected(true);
        }
        txtBirth.setText(tea.getBirth().substring(0, 10));
        txtPhone.setText(tea.getPhone());
        txtEmail.setText(tea.getEmail());
        txtGra.setText(tea.getGraduateSchool());
        txtEdu.setText(tea.getEducation());
        txtDuty.setText(tea.getDuty());
        txtTitle.setText(tea.getTitle());
        Vector vm = DBCon.getData(vTeacher.get(11).toString(), "major");
        cboMajor.setSelectedItem(vm.get(1).toString());
        txtStudy.setText(tea.getStudy());
        txaResume.setText(tea.getResume());
        int status = Integer.parseInt(vTeacher.get(14).toString());
        if (status == 0) {
            lockText();
        } else {
            unlockText();
        }
    }

    void lockText() {
        radMan.setEnabled(false);
        radWoman.setEnabled(false);
        txtBirth.setEnabled(false);
        txtPhone.setEnabled(false);
        txtEmail.setEnabled(false);
        txtGra.setEnabled(false);
        txtEdu.setEnabled(false);
        txtDuty.setEnabled(false);
        txtTitle.setEnabled(false);
        cboMajor.setEnabled(false);
        txtStudy.setEnabled(false);
        txaResume.setEnabled(false);
        btnSave.setEnabled(false);
        btnSubmit.setEnabled(false);
    }

    void unlockText() {
        radMan.setEnabled(true);
        radWoman.setEnabled(true);
        txtBirth.setEnabled(true);
        txtPhone.setEnabled(true);
        txtEmail.setEnabled(true);
        txtGra.setEnabled(true);
        txtEdu.setEnabled(true);
        txtDuty.setEnabled(true);
        txtTitle.setEnabled(true);
        cboMajor.setEnabled(true);
        txtStudy.setEnabled(true);
        txaResume.setEnabled(true);
        btnSave.setEnabled(true);
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
        String gra = txtGra.getText();
        String edu = txtEdu.getText();
        String duty = txtDuty.getText();
        String title = txtTitle.getText();
        String major = cboMajor.getSelectedItem().toString();
        String study = txtStudy.getText();
        String resume = txaResume.getText();
        String majorID = DBCon.getID("Select * from Major where majorName='" +
                                     major + "'");

        String sql = "update Teacher set sex='" + sex + "',birth='" +
                     birth + "',phone='" + phone + "',email='" + email +
                     "',graduateSchool='" + gra + "',education='" + edu +
                     "',duty='" + duty + "',title='" + title + "',study='" +
                     study + "',majorID='" + majorID + "',resume='" +
                     resume + "' where teacherID='" + tea.getId() + "'";
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
        String sql = "update Teacher set status=0 where TeacherID='" +
                     tea.getId() + "'";
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

}


class FrmTeacher_btnSubmit_actionAdapter implements ActionListener {
    private FrmTeacher adaptee;
    FrmTeacher_btnSubmit_actionAdapter(FrmTeacher adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSubmit_actionPerformed(e);
    }
}


class FrmTeacher_btnSave_actionAdapter implements ActionListener {
    private FrmTeacher adaptee;
    FrmTeacher_btnSave_actionAdapter(FrmTeacher adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSave_actionPerformed(e);
    }
}
