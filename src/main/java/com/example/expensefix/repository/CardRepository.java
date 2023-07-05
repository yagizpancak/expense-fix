package com.example.expensefix.repository;

import com.example.expensefix.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CreditCard, Integer> {
}
