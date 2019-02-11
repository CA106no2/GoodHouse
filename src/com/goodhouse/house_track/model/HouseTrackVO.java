package com.goodhouse.house_track.model;

//對應資料庫：房屋追蹤
public class HouseTrackVO implements java.io.Serializable{
	
	private String houTraId;//房屋追蹤編號
	private String memId;//會員編號
	private String houId;//房屋編號
	private String houTraStatus;//房屋追蹤狀態
	public String getHouTraId() {
		return houTraId;
	}
	public void setHouTraId(String houTraId) {
		this.houTraId = houTraId;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getHouId() {
		return houId;
	}
	public void setHouId(String houId) {
		this.houId = houId;
	}
	public String getHouTraStatus() {
		return houTraStatus;
	}
	public void setHouTraStatus(String houTraStatus) {
		this.houTraStatus = houTraStatus;
	}
	
	
}
