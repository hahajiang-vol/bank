package com.maqian.pojo;

import java.io.Serializable;

public class Emp implements Serializable {

	private Integer empid;
	private String empname;
	private String empsex;
	private Integer empage;
	private String empphone;
	private String empaddress;
	private java.util.Date empdate;
	private Integer deptid;
//	private Dept dept;

	public Integer getEmpid(){
		return empid;
	}

	public String getEmpname(){
		return empname;
	}

	public String getEmpsex(){
		return empsex;
	}

	public Integer getEmpage(){
		return empage;
	}

	public String getEmpphone(){
		return empphone;
	}

	public String getEmpaddress(){
		return empaddress;
	}

	public java.util.Date getEmpdate(){
		return empdate;
	}

	

	public void setEmpid(Integer empid){
		this.empid=empid;
	}

	public void setEmpname(String empname){
		this.empname=empname;
	}

	public void setEmpsex(String empsex){
		this.empsex=empsex;
	}

	public void setEmpage(Integer empage){
		this.empage=empage;
	}

	public void setEmpphone(String empphone){
		this.empphone=empphone;
	}

	public void setEmpaddress(String empaddress){
		this.empaddress=empaddress;
	}

	public void setEmpdate(java.util.Date empdate){
		this.empdate=empdate;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

//	public Dept getDept() {
//		return dept;
//	}
//
//	public void setDept(Dept dept) {
//		this.dept = dept;
//	}
	
	

	

}