package com.feicuiedu.atm.service.impl;

import java.util.List;

import com.feicuiedu.atm.dao.UserDao;
import com.feicuiedu.atm.dao.impl.UserDaoImpl;
import com.feicuiedu.atm.entity.Money;
import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.service.UserService;

/**
 * 管理员具体功能
 * @author 王
 */
public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();

	/**
	 * 开户
	 */
	@Override
	public void openAccount(User user) throws Exception {

		userDao.openAccount(user);
		
	}

	/**
	 * 根据身份证号和账号销户
	 */
	@Override
	public void salesByIdNumber(User user) throws Exception {

		userDao.salesByIdNumber(user);
		
	}

	/**
	 * 根据账号修改用户信息
	 */
	@Override
	public void modifyByAccount(User user) throws Exception {

		userDao.modifyByAccount(user);
		
	}

	/**
	 * 查询全部用户信息
	 */
	@Override
	public List<User> queryAccountInfo() throws Exception {
		
		List<User> list = userDao.queryAccountInfo();
		
		return list;
		
	}

	/**
	 * 根据账号查询用户信息
	 */
	@Override
	public User queryByAccountInfo(User user) throws Exception {
		
		return userDao.queryByAccountInfo(user);
		
	}

	/**
	 * 查询所有用户交易记录
	 */
	@Override
	public List<Money> queryRecord() throws Exception {
		
		return userDao.queryRecord();
		
	}

	/**
	 * 根据账号查询用户交易记录
	 */
	@Override
	public Money queryRecordByAccount(Money money) throws Exception {
		
		return userDao.queryRecordByAccount(money);
		
	}

	
	
}
