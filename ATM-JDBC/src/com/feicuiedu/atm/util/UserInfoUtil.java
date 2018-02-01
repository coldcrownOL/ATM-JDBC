package com.feicuiedu.atm.util;

import java.util.Scanner;

/**
 * 用户信息判断
 * @author 王
 */
public class UserInfoUtil {

	/**
	 * 用户姓名判断
	 */
	public String userName(Scanner scan) {
		
		while(true) {
			
			System.out.println("请输入您的姓名(长度不得大于10):");
			String name = scan.next();
			
			if(name.length()<=10 && name.length()>0) {
				
				return name;
				
			} else {
				
				System.out.println("请按照提示重新输入!");
				continue;
			}
		}
	}
	
	/**
	 * 用户密码判断
	 */
	public String password(Scanner scan) {
		
		while(true) {
			
			System.out.println("请输入密码(8-16位,数字和字母必须同时有,至少一个大写字母):");
			String password = scan.next();
			
			if(password.matches("^(?=.*[\\x00-\\xff].*)(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{8,16}$")) {
				
				return password;
				
			} else {
				
				System.out.println("请按照提示重新输入!");
				continue;
			}
		}
	}
	
	/**
	 * 用户性别判断
	 */
	public String gender(Scanner scan) {
		
		while(true){
			
			System.out.println("请输入您的性别(男输入1，女输入2):");
			String gender = scan.next();
			
			if (gender.equals("1")){
				
//				String gender1 = "男";
//				gender = gender1;
//				gender = "男";
				return gender;
				
			} else if (gender.equals("2")){
				
//				String gender2 = "女";
//				gender = gender2;
//				gender = "女";
				return gender;
				
			} else {
				
				System.out.println("请按照提示重新输入");
				continue;
			}
		}
	}
	
	/**
	 * 用户身份证号判断
	 */
	public String idNumber(Scanner scan) {
		
		while(true){
			
			System.out.println("请输入您的身份证号(8位数字):");
			String ID = scan.next();
			
			if(ID.matches("[0-9]{8}")){
				
				return ID;
				
			} else {
				
				System.out.println("身份证号不是8位,请重新输入");
				continue;
			}
		}
	}
	
	/**
	 * 用户学历判断
	 */
	public String education(Scanner scan) {
		
		while(true){
			
			System.out.println("请输入您的学历:(1为小学  2为中学  3为大学  4为其他)");
			String edu = scan.next();
			
			if("1".equals(edu)){
				
				edu = "小学";
				return edu;
				
			} else if("2".equals(edu)){
				
				edu = "中学";
				return edu;
				
			} else if("3".equals(edu)){
				
				edu = "大学";
				return edu;
				
			} else if("4".equals(edu)){
				
				edu = "其它";
				return edu;
				
			} else {
				
				System.out.println("请按照提示重新输入");
				continue;
			}
		}
	}
	
	/**
	 * 用户余额判断
	 */
	public Double balance(Scanner scan) {
		
		Double balance = 0.0;
		
		return balance;
		
	}
	
	/**
	 * 用户地址判断
	 */
	public String address(Scanner scan) {
		
		while(true){
			
			System.out.println("请输入您的联系地址(不得超过50):");
			String address = scan.next();
			
			if(address.length()<50 && address.length()>0){
				
				return address;
				
			} else {
				
				System.out.println("请按照提示重新输入");
				continue;
			}
		}
	}
	
	/**
	 * 用户账号判断
	 */
	public String accountNumber(Scanner scan) {
		
		String account = scan.next();
		return account;
		
	}
	
	/**
	 * 获取系统当前时间转成字符串 yyyyMMddHHmmssSSS
	 * @return 
	 */
//	public String dateToString() {
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//		String time = sdf.format(new Date());
//        
//        return time;
//	}
//	
//	/**
//	 * 获取系统当前时间转成字符串 yyyy-MM-dd HH:mm:ss
//	 */
//	public String date(String time) {
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        time = sdf.format(new Date());
//        
//        return time;
//	}
	
}
