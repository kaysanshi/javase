package com.mingribook;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLDemo {
    public static void main(String[] args) throws SQLException {
        String sql = "select sex, count(sex) from tb_student group by sex;";
        ResultSet rs = DBHelper.query(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1) + "生的人数是：" + rs.getInt(2));
        }
    }
}
