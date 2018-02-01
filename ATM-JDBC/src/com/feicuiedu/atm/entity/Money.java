package com.feicuiedu.atm.entity;

import java.util.Date;

/**
 * 交易属性
 * @author 王
 */
public class Money {

	private String accountOwn;//自己的账号
	private String type;//交易类型
	private Date time;//交易时间
	private Double amount;//交易金额
	private String accountOther;//对方账号
	private Double balanceBefore;//交易前自己的余额
	private Double balanceAfter;//交易后自己的余额
	
	public Money() {
		super();
	}
	
	public Money(String accountOwn, String type, Date time, Double amount,
			String accountOther, Double balanceBefore, Double balanceAfter) {
		super();
		this.accountOwn = accountOwn;
		this.type = type;
		this.time = time;
		this.amount = amount;
		this.accountOther = accountOther;
		this.balanceBefore = balanceBefore;
		this.balanceAfter = balanceAfter;
	}
	
	public String getAccountOwn() {
		return accountOwn;
	}
	public void setAccountOwn(String accountOwn) {
		this.accountOwn = accountOwn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getAccountOther() {
		return accountOther;
	}
	public void setAccountOther(String accountOther) {
		this.accountOther = accountOther;
	}
	public Double getBalanceBefore() {
		return balanceBefore;
	}
	public void setBalanceBefore(Double balanceBefore) {
		this.balanceBefore = balanceBefore;
	}
	public Double getBalanceAfter() {
		return balanceAfter;
	}
	public void setBalanceAfter(Double balanceAfter) {
		this.balanceAfter = balanceAfter;
	}
	
	@Override
	public String toString() {
		return "Money [accountOwn=" + accountOwn + ", type=" + type + ", time=" + time + ", amount=" + amount
				+ ", accountOther=" + accountOther + ", balanceBefore=" + balanceBefore + ", balanceAfter="
				+ balanceAfter + "]";
	}
	
}
