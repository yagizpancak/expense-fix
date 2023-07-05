package com.example.expensefix.repository;

import com.example.expensefix.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    @Query("SELECT DISTINCT e.category FROM Expense e WHERE e.statementID = ?1")
    List<String> findDistinctCategoryByStatementID(int statementID);

    @Query("SELECT e.amount FROM Expense e WHERE e.statementID = ?2 and e.category = ?1")
    List<Float> findAmountByCategoryAndStatementID(String category, int statementID);

    @Query("SELECT e.amount FROM Expense e WHERE e.statementID = ?1")
    List<Float> findAmountByStatementID(int statementID);
}
