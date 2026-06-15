package com.payment.creditcardvalidator.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.payment.creditcardvalidator.dtos.CreateCardRequest;
import com.payment.creditcardvalidator.dtos.ValidateCardRequest;
import com.payment.creditcardvalidator.dtos.ValidationResponse;
import com.payment.creditcardvalidator.entities.Card;
import com.payment.creditcardvalidator.services.CardService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("/validate")
    public ValidationResponse validateCard(
            @Valid @RequestBody ValidateCardRequest request) {
        return cardService.validateCard(request);
    }

    @PostMapping
    public Card createCard(
            @Valid @RequestBody CreateCardRequest request) {
        return cardService.createCard(request);
    }

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }
}
