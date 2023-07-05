package com.example.expensefix.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "statement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private int id;

    @Column(name = "statement_id")
    private int statementID;

    @Column(name = "date")
    private String date;

    @Column(name = "category")
    private String category;

    @Column(name = "amount")
    private float amount;
}
