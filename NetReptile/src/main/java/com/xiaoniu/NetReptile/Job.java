package com.xiaoniu.NetReptile;

public class Job {

	private String cmpname;
	private String jobname;
	private String addr;
	private String salary;
	private String date;
	
	
	public void set(String cmpname, String jobname, String addr, String salary, String date) {
		
		this.cmpname = cmpname;
		this.jobname = jobname;
		this.addr = addr;
		this.salary = salary;
		this.date = date;
	}
	public String getCmpname() {
		return cmpname;
	}
	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Job [cmpname=" + cmpname + ", jobname=" + jobname + ", addr=" + addr + ", salary=" + salary + ", date="
				+ date + "]";
	}
	
	
}
