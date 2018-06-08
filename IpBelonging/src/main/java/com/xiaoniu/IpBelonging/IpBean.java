package com.xiaoniu.IpBelonging;

public class IpBean {

	private String startIp;
	private String endIp;
	private long startDecIp;
	private long endDecIp;
	private String province;
	private String city;
	private String operator;
	
	
	public void set(String startIp, String endIp, long startDecIp, long endDecIp, String province, String city,
			String operator) {
	
		this.startIp = startIp;
		this.endIp = endIp;
		this.startDecIp = startDecIp;
		this.endDecIp = endDecIp;
		this.province = province;
		this.city = city;
		this.operator = operator;
	}
	public String getStartIp() {
		return startIp;
	}
	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}
	public String getEndIp() {
		return endIp;
	}
	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}
	public long getStartDecIp() {
		return startDecIp;
	}
	public void setStartDecIp(long startDecIp) {
		this.startDecIp = startDecIp;
	}
	public long getEndDecIp() {
		return endDecIp;
	}
	public void setEndDecIp(long endDecIp) {
		this.endDecIp = endDecIp;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	@Override
	public String toString() {
		return "IpBean [startIp=" + startIp + ", endIp=" + endIp + ", startDecIp=" + startDecIp + ", endDecIp="
				+ endDecIp + ", province=" + province + ", city=" + city + ", operator=" + operator + "]";
	}
	
	
}
