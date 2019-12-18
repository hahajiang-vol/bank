package com.maqian.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.maqian.dao.CardDAO;
import com.maqian.dao.impl.CardDaoImpl;
import com.maqian.pojo.Card;
import com.maqian.service.CardService;
import com.maqian.util.HibernateUtils;

public class CardServiceImpl implements CardService {

	CardDAO cd = new CardDaoImpl();
	
	@Override
	public void save(Card obj) {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();;
		try{
			cd.save(obj);
			trans.commit();
		} catch(Exception e){
			trans.rollback();
			e.printStackTrace();
		} finally{
			HibernateUtils.coloseSession();
		}

	}

	@Override
	public void update(Card obj) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			cd.update(obj);
			trans.commit();
		} catch(Exception e){
			trans.rollback();
			e.printStackTrace();
		} finally{
			HibernateUtils.coloseSession();
		}
	}

	@Override
	public void delete(Card obj) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			cd.delete(obj);
			trans.commit();
		} catch(Exception e){
			trans.rollback();
			e.printStackTrace();
		} finally{
			HibernateUtils.coloseSession();
		}
	}

	@Override
	public Card findOne(Integer id) {
		// TODO Auto-generated method stub
		Card c = null;
		Session session = HibernateUtils.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			c = cd.findOne(id);
			trans.commit();
		} catch(Exception e){
			trans.rollback();
			e.printStackTrace();
		} finally{
			HibernateUtils.coloseSession();
		}
		return c;
	}

	@Override
	public List<Card> findAll() {
		// TODO Auto-generated method stub
		List<Card> list = new ArrayList<Card>();
		Session session = HibernateUtils.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			list = cd.findAll();
			trans.commit();
		} catch(Exception e){
			trans.rollback();
			e.printStackTrace();
		} finally{
			HibernateUtils.coloseSession();
		}
		return list;
	}

}
