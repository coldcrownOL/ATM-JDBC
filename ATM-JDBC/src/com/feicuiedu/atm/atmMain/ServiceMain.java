package com.feicuiedu.atm.atmMain;

import java.util.Scanner;

import com.feicuiedu.atm.controller.IBaseController;
import com.feicuiedu.atm.util.PropUtil;

/**
 * main方法
 * @author 王
 */
public class ServiceMain {
	

	public static void main(String[] args) {
		
		ServiceMain serviceMain = new ServiceMain();
		serviceMain.runService();
		
	}

	/**
	 * 运行业务
	 */
	public void runService() {
		
		Scanner scan = new Scanner(System.in);
		
		//根据"system"处理系统登录业务 选择 管理员登录   普通用户登录
		IBaseController baseController = (IBaseController) PropUtil.getObjectFromProp("system");
		String result = baseController.execute(scan);
		
		//登录成功后,选择各自的业务
		baseController = (IBaseController) PropUtil.getObjectFromProp(result);
		result = baseController.execute(scan);
		
		scan.close();
		
	}
	
}
