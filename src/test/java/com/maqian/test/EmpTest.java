package com.maqian.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.maqian.pojo.Emp;
import com.maqian.util.HibernateUtils;

public class EmpTest {

	@Test
	public void test() {
		Session sess = HibernateUtils.getSession();
		
		Query query = sess.createQuery("from Emp");
		List<Emp> list = query.list();
		
//		for (Emp emp : list) {
//			System.out.println(emp.getEmpname()+":"+emp.getDept().getDeptname());
//		}
		
		/*Emp emp = (Emp) sess.get(Emp.class, 1);
		System.out.println(emp.getEmpname()+":"+emp.getDept().getDeptname());*/
		StringBuffer str = new StringBuffer("fhsao.sdfsa.sfsaf");
		String lll = "fhsao.sdfs.sfsaf";
		
		String[] temp = lll.split("\\.");
		System.out.println(Arrays.toString(temp));
		
		HibernateUtils.coloseSession();
	}

}
