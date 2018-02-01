package com.feicuiedu.atm.service;

import java.util.Scanner;

/**
 * 系统登录判断
 * @author 王
 */
public interface SystemService {
	
	/**
	 * 管理员登录判断
	 */
	public void adminLogin(Scanner scan);
	
	/**
	 * 普通用户登录判断
	 */
	public void userLogin(Scanner scan);

}
