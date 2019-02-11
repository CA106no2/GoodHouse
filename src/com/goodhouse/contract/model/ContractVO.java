package com.goodhouse.contract.model;


//資料庫對應：合約分類
public class ContractVO implements java.io.Serializable{
	
	private String conId;//合約分類編號
	private String conName;//合約分類名稱
	private String conContent;//合約內容
	
	public String getConId() {
		return conId;
	}
	public void setConId(String conId) {
		this.conId = conId;
	}
	public String getConName() {
		return conName;
	}
	public void setConName(String conName) {
		this.conName = conName;
	}
	public String getConContent() {
		return conContent;
	}
	public void setConContent(String conContent) {
		this.conContent = conContent;
	}
	
	
}