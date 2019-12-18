package com.maqian.action;

import java.util.ArrayList;
import java.util.List;

import com.maqian.pojo.Card;
import com.maqian.service.CardService;
import com.maqian.service.impl.CardServiceImpl;
import com.maqian.util.ReverseDemo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CardAction extends ActionSupport implements ModelDriven<Card> {

	private Card card = new Card();
	private List<Card> list = new ArrayList<Card>();
	
	CardService cs = new CardServiceImpl();

	public Card getCard() {
		return card;
	}

	public List<Card> getList() {
		return list;
	}

	@Override
	public Card getModel() {
		// TODO Auto-generated method stub
		return card;
	}

	public String save(){
//		card.setCid(33);
		cs.save(card);
		return "success";
	}
	
	public String findAll(){
		list = cs.findAll();
		return "success";
	}
	
	public String updateForm(){
		card = cs.findOne(card.getCid());
		return "success";
	}
	
	public String update(){
		cs.update(card);
		return "success";
	}
}
