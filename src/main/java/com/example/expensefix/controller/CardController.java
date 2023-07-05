package com.example.expensefix.controller;

import com.example.expensefix.dto.AddCardRequest;
import com.example.expensefix.model.CreditCard;
import com.example.expensefix.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
	private final CardService cardService;

	@PostMapping("/add_card")
	public void addCard(@RequestBody AddCardRequest addCardRequest){
		cardService.addCard(addCardRequest);
	}
	//TODO
	/*
	@GetMapping("/get_cards/{username}")
	public List<CreditCard> getCards(@PathVariable String username){
		return cardService.getCards(username);
	}
	*/
}
