package com.feicuiedu.atm.service;

import java.util.List;

import com.feicuiedu.atm.entity.Money;

/**
 * 交易记录
 * @author 王
 */
public interface TradeService {

	/**
	 * 添加交易记录
	 */
	public void tradeInfo() throws Exception;
	
	/**
	 * 查询个人交易信息
	 */
	public Money tradeByOwn(Money money) throws Exception;
	
	/**
	 * 查询全部交易信息
	 */
	public List<Money> tradeAll() throws Exception;
	
}
