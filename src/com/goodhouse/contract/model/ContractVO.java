package com.goodhouse.contract.model;


//��Ʈw�����G�X������
public class ContractVO implements java.io.Serializable{
	
	private String conId;//�X�������s��
	private String conName;//�X�������W��
	private String conContent;//�X�����e
	
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