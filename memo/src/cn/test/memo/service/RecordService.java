package cn.test.memo.service;

import java.util.Date;
import java.util.List;

import cn.test.memo.dao.RecordDao;
import cn.test.memo.dao.impl.RecordDaoImpl;
import cn.test.memo.entity.Record;
import cn.test.memo.util.DateUtil;

public class RecordService {
	private RecordDao recordDao;
	
	public RecordService() {
		this.recordDao = new RecordDaoImpl();
	}
	
	public List<Record> query(int pageNum, int page) {
		return recordDao.query(page * pageNum, pageNum);
	}
	
	public int queryNum() {
		return recordDao.queryNum();
	}
	
	public Record query(Integer id) {
		return recordDao.query(id);
	}
	
	public boolean add(Record record) {
		record.setAddtime(DateUtil.udateTostrdatetime(new Date()));
		int res = recordDao.add(record);
		if (res == 0)
			return false;
		return true;
	}
	
	public boolean delete(Record record) {
		int res = recordDao.delete(record.getId());
		if (res == 0)
			return false;
		return true;
	}
	
	public boolean update(Record record) {
		int res = recordDao.update(record);
		if (res == 0)
			return false;
		return true;
	}
}
