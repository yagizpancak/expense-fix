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
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statement_id")
    private int id;

    @Column(name = "user_id")
    private int userID;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "month")
    private String month;

    @Column(name = "bank_name")
    private String bankName;
}
