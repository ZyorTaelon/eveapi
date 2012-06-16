package com.beimin.eveapi.account.accountstatus;

import java.util.Date;

public class EveAccountStatus {
	private int userID; // >271604</userID>
	private Date paidUntil; // >2011-03-13 18:40:00</paidUntil>
	private Date createDate; // >2004-07-22 23:54:00</createDate>
	private int logonCount; // >5603</logonCount>
	private int logonMinutes; // >504903</logonMinutes>

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getPaidUntil() {
		return paidUntil;
	}

	public void setPaidUntil(Date paidUntil) {
		this.paidUntil = paidUntil;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getLogonCount() {
		return logonCount;
	}

	public void setLogonCount(int logonCount) {
		this.logonCount = logonCount;
	}

	public int getLogonMinutes() {
		return logonMinutes;
	}

	public void setLogonMinutes(int logonMinutes) {
		this.logonMinutes = logonMinutes;
	}

}