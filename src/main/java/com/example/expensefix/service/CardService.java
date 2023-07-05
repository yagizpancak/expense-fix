package com.example.expensefix.service;

import com.example.expensefix.dto.AddCardRequest;
import com.example.expensefix.model.CreditCard;
import com.example.expensefix.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
	private final CardRepository cardRepository;

	public void addCard(AddCardRequest addCardRequest) {
		CreditCard creditCard = new CreditCard();
		creditCard.setCardNumber(addCardRequest.getCardNumber());
		creditCard.setBankName(addCardRequest.getBankName());
		creditCard.setUsername(addCardRequest.getUsername());
		creditCard.setName(addCardRequest.getName());

		cardRepository.save(creditCard);
	}
	//TODO
	/*public List<CreditCard> getCards(String username) {
		return cardRepository.findByUsername(username);
	}*/
}
