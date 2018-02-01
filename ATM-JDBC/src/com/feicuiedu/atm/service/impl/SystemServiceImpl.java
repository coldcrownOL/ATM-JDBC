package com.feicuiedu.atm.service.impl;

import java.util.Scanner;

import com.feicuiedu.atm.dao.UserDao;
import com.feicuiedu.atm.dao.impl.UserDaoImpl;
import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.service.SystemService;

/**
 * 系统登录具体判断
 * @author 王
 */
public class SystemServiceImpl implements SystemService{
	
	private User user;
	private UserDao userDao;

	/**
	 * 管理员登录判断
	 */
	@Override
	public void adminLogin(Scanner scan) {
		
		while(true) {
			
			System.out.println("请输入管理员账户(123456):");
			String admin = scan.next();
			
			//判断账号和密码
			if(!"123456".equals(admin)) {
				System.out.println("账户错误,请重新输入!");
				continue;
			}
			
			System.out.println("请输入账户密码(123456):");
			String password = scan.next();
			
			if(!"123456".equals(password)) {
				System.out.println("密码错误,请重新输入!");
				continue;
			}
			
			System.out.println("登录成功!");
			break;
		}
		
	}

	/**
	 * 普通用户登录判断
	 */
	@Override
	public void userLogin(Scanner scan) {
		
		while(true) {
			
			System.out.println("请选择您的登录方式1.银行卡账号 2.身份证号(暂不可用)");
			String select = scan.next();
			
				//银行卡账号登录
			if("1".equals(select)) {
				
				account(scan);
				System.out.println("登录成功");
				
				//身份证号登录
			} 
//			else if("2".equals(select)) {
//				
//				idNumber(scan);
//				System.out.println("登录成功");
//				
//			}
			break;
		}
		
	}
	
	/**
	 * 银行卡账号登录判断
	 */
	public void account(Scanner scan) {
		
		while(true) {
			
			user = new User();
			userDao = new UserDaoImpl();
			
			System.out.println("请输入您的银行卡账号");
			String account = scan.next();
			user.setAccountNumber(account);
			
			User rtnUser = null;
			
			try {
				
				rtnUser = userDao.queryByAccountInfo(user);
				
				if(rtnUser != null) {
						
					System.out.println("请输入您的密码");
					String password = scan.next();
					
					if(password.equals(rtnUser.getPassword())) {
						
						System.out.println("登录成功!");
						
						break;
						
					} else {
						
						System.out.println("密码输入错误!请重新输入");
						continue;
					}
					
				} else {
					
					System.out.println("账号不存在!请重新输入");
					continue;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * 身份证号登录判断
	 */
	public void idNumber(Scanner scan) {
		
		user = new User();
		userDao = new UserDaoImpl();
		
		while(true) {
			
			System.out.println("请输入您的身份证号");
			String id = scan.next();
			user.setAccountNumber(id);
			
			User rtnUser = null;
			
			try {
				
				rtnUser = userDao.queryByIdNumber(user);
				
				if(rtnUser != null) {
						
					System.out.println("请输入您的密码");
					String password = scan.next();
					
					if(password.equals(rtnUser.getPassword())) {
						
						System.out.println("登录成功!");
						
						break;
						
					} else {
						
						System.out.println("密码输入错误!请重新输入");
						continue;
					}
					
				} else {

					System.out.println("账号不存在!请重新输入");
					continue;
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
