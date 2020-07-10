package com.mits.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mits.springboot.entity.CardType;
import com.mits.springboot.repo.CardTypeRepo;
@Service
public class CardTypeService {
	private CardTypeRepo repo;

	@Autowired
	public CardTypeService(CardTypeRepo repo) {
		this.repo = repo;
	}

	public CardType insertOrUpdate(CardType cardType) {
		return repo.save(cardType);
	}

	public List<CardType> insertAll(List<CardType> list) {
		return list.stream().map(this::insertOrUpdate).collect(Collectors.toList());
	}

	public CardType getOne(String id) {
		return repo.getOne(id);
	}

	public List<CardType> getAll() {
		return repo.findAll();
	}

	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public void deleteAll() {
		repo.deleteAll();
	}

}
