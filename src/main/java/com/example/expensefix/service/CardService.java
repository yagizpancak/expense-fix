package com.example.expensefix.service;

import com.example.expensefix.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
	private final CardRepository cardRepository;

}
