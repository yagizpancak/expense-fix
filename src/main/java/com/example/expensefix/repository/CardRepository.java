package com.example.expensefix.repository;

import com.example.expensefix.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CardRepository extends JpaRepository<CreditCard, Integer> {
	@Transactional
	Optional<CreditCard> findByUsername(String username);
}
