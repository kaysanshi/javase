package query;

import java.awt.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Rectangle;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class FrmStuScore extends JFrame {
    JPanel contentPane;
    JLabel lblStuID = new JLabel();
    JLabel lblStuName = new JLabel();
    JButton btnShowAll = new JButton();
    public FrmStuScore() {
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
        setTitle("������Ϣά��");
        lblStuID.setText("ѧ�ţ�");
        lblStuID.setBounds(new Rectangle(33, 11, 42, 15));
        lblStuName.setText("������");
        lblStuName.setBounds(new Rectangle(204, 9, 42, 15));
        btnShowAll.setBounds(new Rectangle(334, 34, 106, 23));
        btnShowAll.setText("��ʾ���гɼ�");
        contentPane.add(lblStuID);
        contentPane.add(lblStuName);
        contentPane.add(btnShowAll);
    }
}
