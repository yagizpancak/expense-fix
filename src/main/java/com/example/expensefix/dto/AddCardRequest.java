package com.example.expensefix.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddCardRequest {

	@NotBlank(message = "Card Number cannot be null!!")
	private String cardNumber;
	@NotBlank(message = "Bank Name cannot be null!!")
	private String bankName;
	@NotBlank(message = "Name cannot be null!!")
	private String name;
	@NotBlank(message = "Username cannot be null!!")
	private String username;
}
