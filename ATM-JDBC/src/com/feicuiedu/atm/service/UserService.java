package com.feicuiedu.atm.service;

import java.util.List;

import com.feicuiedu.atm.entity.Money;
import com.feicuiedu.atm.entity.User;

/**
 * 管理员功能
 * @author 王
 */
public interface UserService {

	/**
	 * 开户
	 */
	public void openAccount(User user) throws Exception;
	
	/**
	 * 根据身份证号和账号销户
	 */
	public void salesByIdNumber(User user) throws Exception;
	
	/**
	 * 根据账号修改用户信息
	 */
	public void modifyByAccount(User user) throws Exception;
	
	/**
	 * 查询全部用户信息
	 */
	public List<User> queryAccountInfo() throws Exception;
	
	/**
	 * 根据账号查询用户信息
	 */
	public User queryByAccountInfo(User user) throws Exception;
	
	/**
	 * 查询所有用户交易记录
	 */
	public List<Money> queryRecord() throws Exception;
	
	/**
	 * 根据账号查询用户交易记录
	 */
	public Money queryRecordByAccount(Money money) throws Exception;
	
}
