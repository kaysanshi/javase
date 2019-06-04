package com.zcib.show;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import com.zcib.db.SqlHelp;
import com.zcib.model.OutStorageModel;

public class Read {
	SqlHelp sHelp=new SqlHelp();
	ResultSet set;
	List list;
	
	public Read() {
		// TODO Auto-generated constructor stub
		OutStorageModel temp=new OutStorageModel();
		String sql1="select id ,name ,amount from goods where 1=?";
		String[]paras={"1"};
		set=sHelp.queryExectue(sql1, paras);
		try {
			list=sHelp.RSToList(set);
			//System.out.println(list);
			//System.out.println(list.listIterator().next().toString());
			int flag=1;
			for(Iterator it=list.iterator();it.hasNext();){
				System.out.println(it.next().toString());
				String sql="insert into outstorage(gid,name,outcount,purplus,date,person) values(?,?,?,?,?,?)";
				String[] pares={};
				if(temp.upOutStorage(sql, pares)){
					System.out.println("出库成功");
				}else{
					System.out.println("出库失败");
					}
					break;
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
