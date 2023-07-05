package com.example.expensefix.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericBadRequestException extends RuntimeException{
	private String message;

	@Override
	public String getMessage(){return this.message; }

}
