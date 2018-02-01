package com.feicuiedu.atm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.feicuiedu.atm.dao.UserDao;
import com.feicuiedu.atm.entity.Money;
import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.util.JDBCUtil;

/**
 * 管理员数据库操作
 * @author 王
 */
public class UserDaoImpl implements UserDao{
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * 开户
	 * @throws SQLException 
	 */
	@Override
	public void openAccount(User user) throws SQLException {

		conn = JDBCUtil.util(conn);
		
		//账号  密码  姓名  性别  身份证号  学历  余额  地址
		String sql = "insert into users values('"+user.getAccountNumber()+
											  "','"+user.getPassword()+
											  "','"+user.getUserName()+
											  "','"+user.getGender()+
											  "','"+user.getIdNumber()+
											  "','"+user.getEducation()+
											  "',"+user.getBalance()+
											  ",'"+user.getAddress()+"')";
		
//		String sql = "insert into users(accountNumber,password,userName,gender,idNumber,education,balance,address) values(?,?,?,?,?,?,?,?)";
//		ps.setString(1, "user.getAccountNumber()");
//		ps.setString(2, "user.getPassword()");
//		ps.setString(3, "user.getUserName()");
//		ps.setString(4, "user.getGender()");
//		ps.setString(5, "user.getIdNumber()");
//		ps.setString(6, "user.getEducation()");
//		ps.setString(7, user.getBalance().toString());
//		ps.setString(8, "user.getAddress()");
		
		// 预加载
		ps = conn.prepareStatement(sql);
		
		//执行更新
		ps.executeUpdate();
		
	}

	/**
	 * 根据身份证号和账号销户
	 */
	@Override
	public void salesByIdNumber(User user) throws Exception {
		
		conn = JDBCUtil.util(conn);
		
		String sql = "delete from users where accountNumber = '"+user.getAccountNumber()
										 +"' and idNumber = '"+user.getIdNumber()+"';";
		
		// 预加载
		ps = conn.prepareStatement(sql);
		
		//执行更新
		ps.executeUpdate();
		
	}

	/**
	 * 根据账号修改用户信息
	 */
	@Override
	public void modifyByAccount(User user) throws Exception {

		conn = JDBCUtil.util(conn);
		
		String sql = "update users set password = '"+user.getPassword()+
									 "',userName = '"+user.getUserName()+
									 "',education = '"+user.getEducation()+
									 "',address = '"+user.getAddress()+
									 "' where accountNumber = '"+user.getAccountNumber()+"';";
		
		// 预加载
		ps = conn.prepareStatement(sql);
		
		//执行更新
		ps.executeUpdate();
		
	}

	/**
	 * 查询全部用户信息
	 */
	@Override
	public List<User> queryAccountInfo() throws Exception {
		
		List<User> list = null;
		
		rs = null;
		
		conn = JDBCUtil.util(conn);
		
		String sql = "select accountNumber,password,userName,"
				   + "gender,idNumber,education,"
				   + "balance,address from users;";
		
		// 预加载
		ps = conn.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		list = new ArrayList<>();
		
		while(rs.next()) {
			
			User user = new User();
			user.setAccountNumber(rs.getString("accountNumber"));
			user.setPassword(rs.getString("password"));
			user.setUserName(rs.getString("userName"));
			user.setGender(rs.getString("gender"));
			user.setIdNumber(rs.getString("idNumber"));
			user.setEducation(rs.getString("education"));
			user.setBalance(Double.valueOf(rs.getString("balance")));
			user.setAddress(rs.getString("address"));
			list.add(user);
			
		}
		
		return list;
	}

	/**
	 * 根据账号查询用户信息
	 */
	@Override
	public User queryByAccountInfo(User user) throws Exception {

		rs = null;
		
		conn = JDBCUtil.util(conn);
		
//		String sql = "select accountNumber,password,userName,"
//				+ "gender,idNumber,education,"
//				+ "balance,address from users"
//				+ "where accountNumber = "+user.getAccountNumber()+";";
		String sql = "select * from users where accountNumber = '"+user.getAccountNumber()+"';";
		
		// 预加载
		ps = conn.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			
			user = new User();
			user.setAccountNumber(rs.getString("accountNumber"));
			user.setPassword(rs.getString("password"));
			user.setUserName(rs.getString("userName"));
			user.setGender(rs.getString("gender"));
			user.setIdNumber(rs.getString("idNumber"));
			user.setEducation(rs.getString("education"));
			user.setBalance(rs.getDouble("balance"));
			user.setAddress(rs.getString("address"));
			
		}
		
		return user;
	}

	/**
	 * 根据身份证号账号查询用户信息
	 */
	@Override
	public User queryByIdNumber(User user) throws Exception {

		rs = null;
		
		conn = JDBCUtil.util(conn);
		
//		String sql = "select accountNumber,password,userName,"
//				+ "gender,idNumber,education,"
//				+ "balance,address from users"
//				+ "where accountNumber = "+user.getAccountNumber()+";";
		String sql = "select * from users where idNumber = '"+user.getIdNumber()+"';";
		
		// 预加载
		ps = conn.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			
			user = new User();
			user.setAccountNumber(rs.getString("accountNumber"));
			user.setPassword(rs.getString("password"));
			user.setUserName(rs.getString("userName"));
			user.setGender(rs.getString("gender"));
			user.setIdNumber(rs.getString("idNumber"));
			user.setEducation(rs.getString("education"));
			user.setBalance(rs.getDouble("balance"));
			user.setAddress(rs.getString("address"));
			
		}
		
		return user;
		
	}


	/**
	 * 查询所有用户交易记录
	 */
	@Override
	public List<Money> queryRecord() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据账号查询用户交易记录
	 */
	@Override
	public Money queryRecordByAccount(Money money) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
