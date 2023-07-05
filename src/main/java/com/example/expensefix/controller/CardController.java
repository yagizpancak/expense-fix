package com.example.expensefix.controller;

import com.example.expensefix.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
	private final CardService cardService;

}
