package com.maqian.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Dept implements Serializable {

	private Integer deptid;
	private String deptname;
	private Integer deptnum;
	private String deptdesc;
	
//	private Set<Emp> emps = new HashSet<Emp>();
	private List<Emp> emps = new ArrayList<Emp>();

	public Integer getDeptid(){
		return deptid;
	}

	public String getDeptname(){
		return deptname;
	}

	public Integer getDeptnum(){
		return deptnum;
	}

	public String getDeptdesc(){
		return deptdesc;
	}

	public void setDeptid(Integer deptid){
		this.deptid=deptid;
	}

	public void setDeptname(String deptname){
		this.deptname=deptname;
	}

	public void setDeptnum(Integer deptnum){
		this.deptnum=deptnum;
	}

	public void setDeptdesc(String deptdesc){
		this.deptdesc=deptdesc;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

//	public Set<Emp> getEmps() {
//		return emps;
//	}
//
//	public void setEmps(Set<Emp> emps) {
//		this.emps = emps;
//	}

	
	
}