package com.maqian.dao;

import java.util.List;

import com.maqian.pojo.Card;

public interface CardDAO {
	
	void save(Card obj);
	
	void update(Card obj);
	
	void delete(Card obj);
	
	Card findOne(Integer id);
	
	List<Card> findAll();
}
