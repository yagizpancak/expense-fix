package com.example.expensefix.repository;

import com.example.expensefix.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatementRepository extends JpaRepository<Statement, Integer> {
    List<Statement> findByUserID(int userID);
    List<Statement> findByUserIDAndMonth(int userID, String month);
    Statement findById(int id);
    Statement findByCardNumberAndMonth(String cardNumber, String month);
    Statement findTopByUserIDOrderByIdDesc(int userID);
    List<Statement> findAllByUserIDOrderByIdDesc(int userID);

}
