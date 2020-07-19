package com.mits.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits.springboot.entity.CardType;

public interface CardTypeRepo extends JpaRepository<CardType, String> {
CardType findByCardTypeName(String cardTypeName);
}
