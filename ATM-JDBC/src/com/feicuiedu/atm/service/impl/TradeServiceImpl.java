package com.feicuiedu.atm.service.impl;

import java.util.List;

import com.feicuiedu.atm.dao.TradeDao;
import com.feicuiedu.atm.dao.impl.TradeDaoImpl;
import com.feicuiedu.atm.entity.Money;
import com.feicuiedu.atm.service.TradeService;

/**
 * 交易记录
 * @author 王
 */
public class TradeServiceImpl implements TradeService{
	
	private TradeDao tradeDao = new TradeDaoImpl();;
	
	/**
	 * 添加交易记录
	 */
	@Override
	public void tradeInfo() throws Exception {
		
		tradeDao.tradeInfo();
	}

	/**
	 * 查询个人交易信息
	 */
	@Override
	public Money tradeByOwn(Money money) throws Exception {
		
		return tradeDao.tradeByOwn(money);
	}

	/**
	 * 查询全部交易信息
	 */
	@Override
	public List<Money> tradeAll() throws Exception {
		
		return tradeDao.tradeAll();
	}

}
