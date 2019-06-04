package studentscoresystem;

//导入包
import java.sql.*;
import java.util.Vector;
import users.*;

public class DBCon {
    public final static int IDNUM = 8; //定义学生学号的位数

    //纯Java连接
    public static Connection JavaCon() {
        try {
            //--1 加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //--2 创建连接
            String url =
                    "jdbc:mysql://localhost:3306/StudentDB";
            Connection conn = DriverManager.getConnection(url, "root", "123");
            System.out.println("数据库连接成功");
            return conn;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("驱动程序找不到");
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQL异常");
            return null;
        }
    }

    //验证用户账号的方法
    public static boolean validateUser(String id) {
        try {
            //连接数据库
            Connection conn = JavaCon();
            //创建会话
            Statement stmt = conn.createStatement();
            String sql = "";
            //判断是教师还是学生，然后写出相应的SQL语句
            if (id.length() >= IDNUM) {
                sql = "Select * from Student where studentID='" + id +
                      "'";
            } else {
                sql = "Select * from Teacher where teacherID='" + id +
                      "'";
            }
            //执行SQL语句，获得查询的结果
            ResultSet rs = stmt.executeQuery(sql);
            boolean validate = true;
            if (rs == null || !rs.next()) {
                validate = false;
            }
            //关闭
            stmt.close();
            conn.close();
            return validate;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    //验证用户密码的方法
    public static boolean validatePwd(Users user) {
        try {
            //连接数据库
            Connection conn = JavaCon();
            //创建会话
            Statement stmt = conn.createStatement();
            //获得用户的账号
            String id = user.getId();
            //获得用户的密码
            String password = user.getPassword();
            String sql = "";
            //判断是教师还是学生，然后写出相应的SQL语句
            if (id.length() >= IDNUM) {
                sql = "Select * from Student where studentID='" + id +
                      "' and password='" + password + "'";
            } else {
                sql = "Select * from Teacher where teacherID='" + id +
                      "' and password='" + password + "'";
            }
            //执行SQL语句，获得查询的结果
            ResultSet rs = stmt.executeQuery(sql);
            boolean validate = true;
            if (rs == null || !rs.next()) {
                validate = false;
            }
            //关闭
            stmt.close();
            conn.close();
            return validate;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    //获取数据的方法
    public static Vector getData(String id, String tableName) {
        try {
            //连接数据库
            Connection conn = JavaCon();
            //创建会话
            Statement stmt = conn.createStatement();
            String sql = "";
            sql = "Select * from " + tableName + " where " + tableName + "ID='" +
                  id + "'";
            //执行SQL语句，获得查询的结果
            ResultSet rs = stmt.executeQuery(sql);
            Vector data = new Vector();
            //将结果集中的数据放置到Vector中
            rs.next();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columCount = rsmd.getColumnCount();
            for (int i = 1; i <= columCount; i++) {
                data.add(rs.getObject(i));
            }
            //关闭
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
            //连接数据库
            Connection conn = JavaCon();
            //创建会话
            Statement stmt = conn.createStatement();
            //执行SQL语句，获得查询的结果
            ResultSet rs = stmt.executeQuery(sql);
            Vector data = new Vector();
            //将结果集中的数据放置到Vector中
            ResultSetMetaData rsmd = rs.getMetaData();
            int columCount = rsmd.getColumnCount();
            while (rs.next()) {
                Vector line = new Vector();
                for (int i = 1; i <= columCount; i++) {
                    line.add(rs.getObject(i));
                }
                data.add(line);
            }
            //关闭
            rs.close();
            stmt.close();
            conn.close();
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //获得ID的方法
    public static String getID(String sql) {
        try {
            //连接数据库
            Connection conn = JavaCon();
            //创建会话
            Statement stmt = conn.createStatement();
            //执行SQL语句，获得查询的结果
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            String id = rs.getObject(1).toString();
            //关闭
            rs.close();
            stmt.close();
            conn.close();
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //更新数据的方法
    public static boolean updateData(String sql) {
        try {
            //连接数据库
            Connection conn = JavaCon();
            //创建会话
            Statement stmt = conn.createStatement();
            //执行SQL语句，更新数据
            int r = stmt.executeUpdate(sql);
            //关闭
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
