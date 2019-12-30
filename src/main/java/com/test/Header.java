package com.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "header")
public class Header {

	private String BustinNo;

	private String chnl;

	private String serialNo;

	private String tradeDate;

	public String getBustinNo() {
		return BustinNo;
	}

	public void setBustinNo(String bustinNo) {
		BustinNo = bustinNo;
	}

	public String getChnl() {
		return chnl;
	}

	public void setChnl(String chnl) {
		this.chnl = chnl;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

}
