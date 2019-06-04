package studentscoresystem;

//�����
import java.sql.*;
import java.util.Vector;
import users.*;

public class DBCon {
    public final static int IDNUM = 8; //����ѧ��ѧ�ŵ�λ��

    //��Java����
    public static Connection JavaCon() {
        try {
            //--1 ������������
            Class.forName("com.mysql.jdbc.Driver");
            //--2 ��������
            String url =
                    "jdbc:mysql://localhost:3306/StudentDB";
            Connection conn = DriverManager.getConnection(url, "root", "123");
            System.out.println("���ݿ����ӳɹ�");
            return conn;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("���������Ҳ���");
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQL�쳣");
            return null;
        }
    }

    //��֤�û��˺ŵķ���
    public static boolean validateUser(String id) {
        try {
            //�������ݿ�
            Connection conn = JavaCon();
            //�����Ự
            Statement stmt = conn.createStatement();
            String sql = "";
            //�ж��ǽ�ʦ����ѧ����Ȼ��д����Ӧ��SQL���
            if (id.length() >= IDNUM) {
                sql = "Select * from Student where studentID='" + id +
                      "'";
            } else {
                sql = "Select * from Teacher where teacherID='" + id +
                      "'";
            }
            //ִ��SQL��䣬��ò�ѯ�Ľ��
            ResultSet rs = stmt.executeQuery(sql);
            boolean validate = true;
            if (rs == null || !rs.next()) {
                validate = false;
            }
            //�ر�
            stmt.close();
            conn.close();
            return validate;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    //��֤�û�����ķ���
    public static boolean validatePwd(Users user) {
        try {
            //�������ݿ�
            Connection conn = JavaCon();
            //�����Ự
            Statement stmt = conn.createStatement();
            //����û����˺�
            String id = user.getId();
            //����û�������
            String password = user.getPassword();
            String sql = "";
            //�ж��ǽ�ʦ����ѧ����Ȼ��д����Ӧ��SQL���
            if (id.length() >= IDNUM) {
                sql = "Select * from Student where studentID='" + id +
                      "' and password='" + password + "'";
            } else {
                sql = "Select * from Teacher where teacherID='" + id +
                      "' and password='" + password + "'";
            }
            //ִ��SQL��䣬��ò�ѯ�Ľ��
            ResultSet rs = stmt.executeQuery(sql);
            boolean validate = true;
            if (rs == null || !rs.next()) {
                validate = false;
            }
            //�ر�
            stmt.close();
            conn.close();
            return validate;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    //��ȡ���ݵķ���
    public static Vector getData(String id, String tableName) {
        try {
            //�������ݿ�
            Connection conn = JavaCon();
            //�����Ự
            Statement stmt = conn.createStatement();
            String sql = "";
            sql = "Select * from " + tableName + " where " + tableName + "ID='" +
                  id + "'";
            //ִ��SQL��䣬��ò�ѯ�Ľ��
            ResultSet rs = stmt.executeQuery(sql);
            Vector data = new Vector();
            //��������е����ݷ��õ�Vector��
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columCount = rsmd.getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                data.add(rs.getObject(i));
            }
            //�ر�
            rs.close();
            stmt.close();
            conn.close();
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Vector getData(String sql) {
        try {
            //�������ݿ�
            Connection conn = JavaCon();
            //�����Ự
            Statement stmt = conn.createStatement();
            //ִ��SQL��䣬��ò�ѯ�Ľ��
            ResultSet rs = stmt.executeQuery(sql);
            Vector data = new Vector();
            //��������е����ݷ��õ�Vector��
            ResultSetMetaData rsmd = rs.getMetaData();
            int columCount = rsmd.getColumnCount();
            while (rs.next()) {
                Vector line = new Vector();
                for (int i = 1; i <= columCount; i++) {
                    line.add(rs.getObject(i));
                }
                data.add(line);
            }
            //�ر�
            rs.close();
            stmt.close();
            conn.close();
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //���ID�ķ���
    public static String getID(String sql) {
        try {
            //�������ݿ�
            Connection conn = JavaCon();
            //�����Ự
            Statement stmt = conn.createStatement();
            //ִ��SQL��䣬��ò�ѯ�Ľ��
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            String id = rs.getObject(1).toString();
            //�ر�
            rs.close();
            stmt.close();
            conn.close();
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //�������ݵķ���
    public static boolean updateData(String sql) {
        try {
            //�������ݿ�
            Connection conn = JavaCon();
            //�����Ự
            Statement stmt = conn.createStatement();
            //ִ��SQL��䣬��������
            int r = stmt.executeUpdate(sql);
            //�ر�
            stmt.close();
            conn.close();
            if (r > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
