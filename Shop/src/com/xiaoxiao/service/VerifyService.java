package com.xiaoxiao.service;

import java.util.Calendar;
import java.util.Date;

import com.xiaoxiao.dao.UserDao;
import com.xiaoxiao.dao.VerifyDao;
import com.xiaoxiao.domain.Verify;
import com.xiaoxiao.exception.UserException;

public class VerifyService {
	private VerifyDao verifyDao = new VerifyDao();
	UserDao userDao = new UserDao();

	// 将验证码写入到表中
	public void addverify(int vipid, String code) {
		Date dt = new Date();
		dt = checkOption("next", dt);
		verifyDao.addverify(vipid, code, dt);

	}

	// 激活账号
	public void activate(String code) throws UserException {
		/*
		 * 1.查看激活码是否正确，不正确抛出异常，正确并获取vipid 
		 * 2.根据vipid，查看是否已激活，已经激活，抛出异常 
		 * 3.没有激活，则激活
		 */
		// 1.查看激活码是否正确，不正确抛出异常，正确并获取vipid
		Verify vr = verifyDao.findByCode(code);
		if (vr == null) {
			throw new UserException("激活码错误！");
		}
		if (vr.getExpiredate().getTime() < (new Date()).getTime()) {
			throw new UserException("激活码已过期！");
		}
		int vipid = vr.getVipid();
		// 2.根据vipid，查看是否已激活，已经激活，抛出异常
		if (userDao.findStatus(vipid)) {// 已激活
			throw new UserException("请不要重复激活！");
		}
		userDao.updateStatus(vipid);// 激活

	}

	public static Date checkOption(String option, Date _date) {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cl = Calendar.getInstance();
		Date date = null;

		date = _date;
		cl.setTime(date);
		if ("pre".equals(option)) {
			// 时间减一天
			cl.add(Calendar.DAY_OF_MONTH, -1);

		} else if ("next".equals(option)) {
			// 时间加一天
			cl.add(Calendar.DAY_OF_YEAR, 1);
		} else {
			// do nothing
		}
		date = cl.getTime();
		return date;
	}
}
