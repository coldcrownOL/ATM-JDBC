package com.feicuiedu.atm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.feicuiedu.atm.dao.TradeDao;
import com.feicuiedu.atm.entity.Money;
import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.util.JDBCUtil;

/**
 * 添加交易记录到数据库
 * @author 王
 */
public class TradeDaoImpl implements TradeDao{
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Money money;
	private User user;

	/**
	 * 添加交易记录到数据库
	 */
	@Override
	public void tradeInfo() throws Exception {

		conn = JDBCUtil.util(conn);
		
		String sql = "insert into money values("+money.getAccountOwn()
												+money.getType()
												+money.getTime()
												+money.getAmount()
												+money.getAccountOther()
												+money.getBalanceBefore()
												+money.getBalanceAfter()+");";
		
		// 预加载
		ps = conn.prepareStatement(sql);
		
		//执行更新
		ps.executeUpdate();
		
	}

	/**
	 * 查询个人交易信息
	 */
	@Override
	public Money tradeByOwn(Money money) throws Exception {
		
		rs = null;
		
		conn = JDBCUtil.util(conn);
		
//		String sql = "select accountNumber,password,userName,"
//				+ "gender,idNumber,education,"
//				+ "balance,address from users"
//				+ "where accountNumber = "+user.getAccountNumber()+";";
		String sql = "select * from money where accountOwn = "+user.getAccountNumber()+";";
		
		// 预加载
		ps = conn.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			
			money = new Money();
			money.setAccountOwn(rs.getString("accountOwn"));
			money.setType(rs.getString("type"));
			money.setTime(rs.getDate("time"));
			money.setAmount(rs.getDouble("amount"));
			money.setAccountOther(rs.getString("accountOther"));
			money.setBalanceBefore(rs.getDouble("balanceBefore"));
			money.setBalanceAfter(rs.getDouble("balanceAfter"));
			
		}
		
		return money;
	}

	/**
	 * 查询全部交易信息
	 */
	@Override
	public List<Money> tradeAll() throws Exception {

		List<Money> list = null;
		
		rs = null;
		
		conn = JDBCUtil.util(conn);
		
//		String sql = "select accountOwn,type,time,"
//				   + "amonut,accountOther,balanceBefore,"
//				   + "balanceAfter from money;";
		String sql = "select * from money";
		// 预加载
		ps = conn.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		list = new ArrayList<>();
		
		while(rs.next()) {
			
			Money money = new Money();
			money.setAccountOwn(rs.getString("accountOwn"));
			money.setType(rs.getString("type"));
			money.setTime(Timestamp.valueOf(rs.getString("time")));
			money.setAmount(Double.valueOf(rs.getString("amonut")));
			money.setAccountOther(rs.getString("accountOther"));
			money.setBalanceBefore(Double.valueOf(rs.getString("balanceBefore")));
			money.setBalanceAfter(Double.valueOf(rs.getString("balanceAfter")));
			list.add(money);
		}
		
		return list;
		
	}
}
