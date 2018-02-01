package com.feicuiedu.atm.controller;

import java.util.Scanner;

import com.feicuiedu.atm.service.SystemService;
import com.feicuiedu.atm.util.PropUtil;
import com.feicuiedu.atm.view.SystemView;

/**
 * 系统登录处理
 * @author 王
 */
public class SystemController implements IBaseController{
	
	private SystemView systemView;
	private SystemService systemService;

	@Override
	public String execute(Scanner scan) {
		
		while(true) {
			
			systemService = (SystemService) PropUtil.getObjectFromProp("systemService");
			
			//显示ATM登录选择界面
			systemView = new SystemView();
			systemView.showView();
			
			String result = null;
			String select = scan.next();
			
			// 1.管理员登录
			if("1".equals(select)) {
				
				systemService.adminLogin(scan);
				result = "user";
				
			// 2.普通用户登录
			} else if("2".equals(select)) {
				
				systemService.userLogin(scan);
				result = "money";
				
			// 3.退卡
			} else if("3".equals(select)) {
				
				System.exit(0);
				
			} else {
				
				System.out.println("请按照提示进行操作!");
				continue;
				
			}
			
			return result;
			
		}
		
	}

}
