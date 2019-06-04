package cn.test.memo.dao;

import java.util.List;

import cn.test.memo.entity.Record;

public interface RecordDao {
	public List<Record> query(int start, int num);
	public int queryNum();
	public Record query(Integer id);
	public int add(Record record);
	public int update(Record record);
	public int delete(Integer id);
}
