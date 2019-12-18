package com.maqian.test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.maqian.pojo.Dept;
import com.maqian.pojo.Emp;
import com.maqian.util.HibernateUtils;

public class DeptTest {

	@Test
	public void test() {
		Session sess = HibernateUtils.getSession();
		
		Dept dept = (Dept) sess.get(Dept.class, 1);
		System.out.println(dept.getDeptname());
		for (Emp emp : dept.getEmps()) {
			System.out.println(emp.getEmpname());
		}
		
		
	}

}
