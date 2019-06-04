package cn.test.memo.dao.impl;

import java.util.List;
import java.util.Map;

import cn.test.memo.dao.RecordDao;
import cn.test.memo.entity.Record;
import cn.test.memo.util.BeanHandler;
import cn.test.memo.util.JdbcUtil;

public class RecordDaoImpl implements RecordDao {

	@Override
	public List<Record> query(int start, int num) {
		// TODO Auto-generated method stub
		String sql = "select * from record limit ?,?";
		return JdbcUtil.query(sql, new BeanHandler<Record>(Record.class), start, num);
	}
	
	@Override
	public int queryNum() {
		// TODO Auto-generated method stub
		String sql = "select count(*) as num from record";
		List<Map<String, Object>> res = JdbcUtil.query(sql);
		return Integer.parseInt(res.get(0).get("num").toString());
	}

	@Override
	public Record query(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from record where id=?";
		List<Record> list = JdbcUtil.query(sql, new BeanHandler<Record>(Record.class), id);
		if (list.size() == 0)
			return null;
		return list.get(0);
	}
	
	@Override
	public int add(Record record) {
		// TODO Auto-generated method stub
		String sql = "insert into record (title, text, time, addtime) values (?,?,?,?)";
		return JdbcUtil.update(sql, record.getTitle(), record.getText(), record.getTime(), record.getAddtime());
	}

	@Override
	public int update(Record record) {
		// TODO Auto-generated method stub
		String sql = "update record set title=?,text=?,time=? where id=?";
		return JdbcUtil.update(sql, record.getTitle(), record.getText(), record.getTime(), record.getId());
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from record where id=?";
		return JdbcUtil.update(sql, id);
	}

}
