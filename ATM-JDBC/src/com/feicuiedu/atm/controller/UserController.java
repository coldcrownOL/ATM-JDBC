package com.feicuiedu.atm.controller;

import java.util.List;
import java.util.Scanner;

import com.feicuiedu.atm.entity.Money;
import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.service.TradeService;
import com.feicuiedu.atm.service.UserService;
import com.feicuiedu.atm.util.DateUtil;
import com.feicuiedu.atm.util.PropUtil;
import com.feicuiedu.atm.view.UserView;

public class UserController implements IBaseController {
	
	private UserView userView;
	private UserService us;
	private TradeService ts;
	private SystemController sc;
	private User user;

	@Override
	public String execute(Scanner scan) {
		
		us = (UserService) PropUtil.getObjectFromProp("userService");
		
		while(true) {
			
			//显示管理员功能选择界面
			userView = new UserView();
			userView.showView();
			
			String select = scan.next();
			
			//1.开户
			if("1".equals(select)) {
				
				//接收用户信息
				user = new User();
				
				//用户密码
				System.out.println("请输入密码");
				String password = scan.next();
				user.setPassword(password);
				
				//用户姓名
				System.out.println("请输入姓名");
				String name = scan.next();
				user.setUserName(name);
				
				//用户身份证号
				System.out.println("请输入身份证号");
				String ID = scan.next();
				user.setIdNumber(ID);
				
				//用户学历
				System.out.println("请输入学历(1.小学 2.中学 3.大学 4.其他)");
				String edu = scan.next();
				user.setEducation(edu);
				
				//用户地址
				System.out.println("请输入地址");
				String address = scan.next();
				user.setAddress(address);
				
				//用户余额
				Double balance = 0.0;
				user.setBalance(balance);
				
				//用户性别
				System.out.println("请输入性别(1.男 2.女)");
				String gender = scan.next();
				if(gender.equals("1")) {
//					
					user.setGender("男");
					
				} else if(gender.equals("2")) {

					user.setGender("女");
					
				}
				
				//接收用户账户
				String account = "370"+ gender + DateUtil.dateToString();//账户
				user.setAccountNumber(account);
				
				try {
					
					us.openAccount(user);
					System.out.println("开户成功");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				continue;
				
				//2.销户
			} else if("2".equals(select)) {

				user = new User();
				
				//接收用户账号
				System.out.println("请输入您的账号:");
				String account = scan.next();
				user.setAccountNumber(account);
				
				//接收用户身份证号
				System.out.println("请输入您的身份证号(8位数字):");
				String ID = scan.next();
				user.setIdNumber(ID);
				
				try {
					
					us.salesByIdNumber(user);
					System.out.println("销户成功");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				continue;
				
				 //3.显示所有账户信息 
			} else if("3".equals(select)) {
				
				List<User> list;
				try {
					
					list = us.queryAccountInfo();
					
					for (User user : list) {
						System.out.println(user);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("查询成功!");
				
				continue;
				
				//4.修改账户信息 
			} else if("4".equals(select)) {
				
				user = new User();
				
				//要修改的账号
				System.out.println("请输入您要修改的账号");
				String account = scan.next();
				user.setAccountNumber(account);
				
				//修改后的密码
				System.out.println("请输入修改后的密码(8-16位,数字和字母必须同时有,至少一个大写字母):");
				String password = scan.next();
				user.setPassword(password);
				
				//修改后的的姓名
				System.out.println("请输入您修改后的的姓名(长度不得大于10):");
				String name = scan.next();
				user.setUserName(name);
				
				//修改后的的学历
				System.out.println("请输入您修改后的的学历:(1为小学  2为中学  3为大学  4为其他)");
				String edu = scan.next();
				user.setEducation(edu);
				
				//修改后的的联系地址
				System.out.println("请输入您修改后的的联系地址(不得超过50):");
				String address = scan.next();
				user.setAddress(address);
				
				try {
					
					us.modifyByAccount(user);
					System.out.println("修改成功");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				continue;
				
				// 5.显示所有账户交易记录
			} else if("5".equals(select)){
				
				List<Money> list;
				try {
					
					list = ts.tradeAll();
					
					for (Money money : list) {
						System.out.println(money);
					}
					
					System.out.println("查询成功!");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				continue;
				
				//6.返回上一级 
			} else if("6".equals(select)) {
				
				sc = new SystemController();
				sc.execute(scan);
				
				//7.退卡
			} else if("7".equals(select)) {
				
				System.exit(0);
			}
			
		}
		
	}

}
