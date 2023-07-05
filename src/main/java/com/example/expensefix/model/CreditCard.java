package com.example.expensefix.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "card_id")
	private int id;

	@Column(name= "card_number")
	private String cardNumber;

	@Column(name= "bank_name")
	private String bankName;

	@Column(name= "card_user")
	private String username;
}
