package com.maqian.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.maqian.pojo.Card;
import com.maqian.util.HibernateUtils;

public class CardTest {

	@Test
	public void test() {
		Session session = HibernateUtils.getSession();
		System.out.println(session);
		Transaction trans = session.beginTransaction();
		
		Card c= new Card();
		c.setCno("1007");
		c.setCname("hahha");
		c.setCmoney(99D);
		
		session.save(c);
		
		trans.commit();
		session.close();
	}

}
