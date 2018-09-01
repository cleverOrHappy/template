package com.entity;

import java.io.Serializable;

/**
 * 账户实体类
 * @author zyh
 *
 */
public class Admin implements Serializable {;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 账户id
	 */
	private  String accountId;
	//账户密码
	private String accountPassWord;
	//账户姓名
    private String accountName;
	//账户备注
    private String remark;
	//账户创建人
    private String createAccountId;
	//账户创建时间
    private String createDate;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String loginId) {
		this.accountId = loginId;
	}
	public String getAccountPassWord() {
		return accountPassWord;
	}
	public void setAccountPassWord(String accountPassWord) {
		this.accountPassWord = accountPassWord;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateAccountId() {
		return createAccountId;
	}
	public void setCreateAccountId(String createAccountId) {
		this.createAccountId = createAccountId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountPassWord=" + accountPassWord + ", accountName="
				+ accountName + ", remark=" + remark + ", createAccountId=" + createAccountId + ", createDate="
				+ createDate + "]";
	}
    

}
