package com.feicuiedu.atm.controller;

import java.util.List;
import java.util.Scanner;

import com.feicuiedu.atm.entity.Money;
import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.service.TradeService;
import com.feicuiedu.atm.service.UserService;
import com.feicuiedu.atm.service.impl.UserServiceImpl;
import com.feicuiedu.atm.util.DateUtil;
import com.feicuiedu.atm.util.PropUtil;
import com.feicuiedu.atm.view.MoneyView;


/**
 * 普通用户控制流程
 * @author 王
 */
public class MoneyController implements IBaseController{
	
	private MoneyView mv;
	private User user;
	private UserService userService;
	private Money money;
	private TradeService tradeService;
	private SystemController sc;

	@Override
	public String execute(Scanner scan) {
		
		//1.存款 2.取款 3.转账 4.查询 5.交易流水 6.返回上一级 7.退卡
		while(true) {
			
			userService = (UserService) PropUtil.getObjectFromProp("userService");
			
			//显示普通用户功能选择界面
			mv = new MoneyView();
			mv.showView();
			
			String select = scan.next();
			
				//1.存款
			if("1".equals(select)) {
				
				user = new User();
				money = new Money();
				
				//获取当前账户登录信息
				
//				user.setAccountNumber();
				
				System.out.println();
				//根据账号查找账户信息
				User rtnUser = null;
				try {
					
					rtnUser = userService.queryByAccountInfo(user);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				System.out.println("您的余额为:"+rtnUser.getBalance());
				money.setBalanceBefore(rtnUser.getBalance());
				
				//交易金额
				Double tradeMoney = scan.nextDouble();
				
				user.setBalance(rtnUser.getBalance()+tradeMoney);
				userService = new UserServiceImpl();
				
				try {
					
					userService.modifyByAccount(rtnUser);
					
					money.setAccountOwn(rtnUser.getAccountNumber());
					money.setType("存款");
					money.setTime(DateUtil.date());
					money.setAmount(tradeMoney);
					money.setAccountOther(rtnUser.getAccountNumber());
					money.setBalanceAfter(rtnUser.getBalance());
					
					System.out.println("存款成功，现在的余额为:"+rtnUser.getBalance());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				continue;
				
				// 2.取款
			} else if("2".equals(select)) {
				
				user = new User();
				money = new Money();
				
				//获取当前登录账户信息
				
				
				System.out.println("您的余额为:"+user.getBalance());
				money.setBalanceBefore(user.getBalance());
				
				//交易金额
				Double tradeMoney = scan.nextDouble();
				
				//取款金额不得大于余额
				if(tradeMoney>user.getBalance()){
					
					System.out.println("取款金额不得大于余额，请重新输入");
					continue;
					
				} 
				
				user.setBalance(user.getBalance()-tradeMoney);
				userService = new UserServiceImpl();
				
				try {
					
					userService.modifyByAccount(user);
					
					System.out.println("取款成功，现在的余额为:"+user.getBalance());
					
					money.setAccountOwn(user.getAccountNumber());
					money.setType("取款");
					money.setTime(DateUtil.date());
					money.setAmount(tradeMoney);
					money.setAccountOther(user.getAccountNumber());
					money.setBalanceAfter(user.getBalance());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				continue;
				
				// 3.转账
			} else if("3".equals(select)) {
				
//				String accountOther;
				while(true) {
					
					User userOther = new User();
					money = new Money();
					userService = new UserServiceImpl();
					
					System.out.println("请输入对方账户");
					String accountOther = scan.next();
					userOther.setAccountNumber(accountOther);
					
					User rtnUser = null;
					try {
						
						rtnUser = userService.queryByAccountInfo(userOther);
						
						if(rtnUser == null) {
							System.out.println("账户不存在,请重新输入!");
							continue;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					//获取当前登录账户信息
					
					
					System.out.println("您的余额为:"+user.getBalance());
					money.setBalanceBefore(user.getBalance());
					
					//转账金额
					Double tradeMoney = scan.nextDouble();
					
					//转账金额不得大于余额
					if( tradeMoney > user.getBalance() ){
						
						System.out.println("转账金额不得大于余额，请重新输入");
						continue;
							
					} 
					
					userOther.setBalance(rtnUser.getBalance()+tradeMoney);//转账后对方的余额
					user.setBalance(user.getBalance()-tradeMoney);//转账后自己的余额
					
					userService = new UserServiceImpl();
					
					//修改对方账户金额
					try {
						
						userService.modifyByAccount(userOther);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					//修改登录账户金额
					try {
						
						userService.modifyByAccount(user);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("转账成功，现在的余额为:"+user.getBalance());
					
					money.setAccountOwn(user.getAccountNumber());
					money.setType("存款");
					money.setTime(DateUtil.date());
					money.setAmount(tradeMoney);
					money.setBalanceAfter(user.getBalance());
					break;
				}
				
				continue;
				
				// 4.查询个人信息
			} else if("4".equals(select)) {
				
				user = new User();
				
				//获取当前登录账户信息
				
				
				System.out.println("账户卡号:"+user.getAccountNumber());
				System.out.println("账户所有人:"+user.getUserName());
				System.out.println("账户余额:"+user.getBalance());
				
				continue;
				
				// 5.查询个人交易流水
			} else if("5".equals(select)) {
				
				money = new Money();
				
				//获取当前登录账户信息
				
				
				user.setAccountNumber(user.getAccountNumber());
				
				try {
					
					Money rtnMoney = tradeService.tradeByOwn(money);
					System.out.println(rtnMoney);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				continue;
				
				// 6.返回上一级
			} else if("6".equals(select)) {
				
				sc = new SystemController();
				sc.execute(scan);
				
				// 7.退卡
			} else if("7".equals(select)) {
				
				System.exit(0);
			}
			
		}
		
	}

}
