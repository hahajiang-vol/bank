package com.maqian.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static ThreadLocal<Session> tl = new ThreadLocal<Session>();
	private static SessionFactory sessionFactor;
	
	static{
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		sessionFactor = config.buildSessionFactory();
	}
	
	public static Session getSession(){
		Session session = tl.get();
		if(session==null){
			session = sessionFactor.openSession();
			tl.set(session);
		}
		return session;
	}
	
	
	public static void coloseSession(){
		Session session = tl.get();
		if(session!=null){
			session.close();
			tl.set(null);
		}
	}
	
}
