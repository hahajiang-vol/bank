package com.maqian.dao.impl;

import java.util.List;

import com.maqian.dao.CardDAO;
import com.maqian.pojo.Card;
import com.maqian.util.HibernateUtils;

public class CardDaoImpl implements CardDAO {

	
	@Override
	public void save(Card obj) {
		// TODO Auto-generated method stub
		HibernateUtils.getSession().save(obj);
	}

	@Override
	public void update(Card obj) {
		// TODO Auto-generated method stub
		HibernateUtils.getSession().update(obj);
	}

	@Override
	public void delete(Card obj) {
		// TODO Auto-generated method stub
		HibernateUtils.getSession().delete(obj);
	}

	@Override
	public Card findOne(Integer id) {
		return (Card) HibernateUtils.getSession().get(Card.class, id);
	}

	@Override
	public List<Card> findAll() {
		List<Card> list = HibernateUtils.getSession().createQuery("from Card").list();
		return list;
	}

}
