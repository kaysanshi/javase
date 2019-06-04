package com.itheima.lob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import com.itheima.util.JDBCUtils;

/*
	create table blobdemo(
		id int primary key auto_increment,
		name varchar(100),
		content MEDIUMBLOB
	);
 */

//处理二进制文件；
public class BlobDemo1 {

	public void findBlob(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("select * from blobdemo");
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				InputStream in = rs.getBinaryStream("content");
				OutputStream out = new FileOutputStream(name);
				
				byte [] bs = new byte[1024];
				int i = 0;
				while((i=in.read(bs))!=-1){
					out.write(bs,0,i);
				}
				in.close();
				out.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}

	public void addBlob(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("insert into blobdemo values (null,?,?)");
			ps.setString(1, "洛天依.mp3");
			File file = new File("1.mp3");
			ps.setBinaryStream(2, new FileInputStream(file),(int)file.length());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	public static void main(String[] args) {
		BlobDemo1 b1=new BlobDemo1();
		b1.addBlob();
	}
}
