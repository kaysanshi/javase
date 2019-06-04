package com.itheima.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MyResultSetHandler<T> {
	T handle(ResultSet rs) throws SQLException;
}
