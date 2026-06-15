package com.payment.creditcardvalidator.services;

import java.util.List;

import com.payment.creditcardvalidator.dtos.CreateCardRequest;
import com.payment.creditcardvalidator.dtos.ValidateCardRequest;
import com.payment.creditcardvalidator.dtos.ValidationResponse;
import com.payment.creditcardvalidator.entities.Card;

public interface CardService {

    ValidationResponse validateCard(ValidateCardRequest request);

    Card createCard(CreateCardRequest request);

    List<Card> getAllCards();

}
