package com.payment.creditcardvalidator.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payment.creditcardvalidator.dtos.CreateCardRequest;
import com.payment.creditcardvalidator.dtos.ValidateCardRequest;
import com.payment.creditcardvalidator.dtos.ValidationResponse;
import com.payment.creditcardvalidator.entities.Card;
import com.payment.creditcardvalidator.entities.Transaction;
import com.payment.creditcardvalidator.enums.TransactionStatus;
import com.payment.creditcardvalidator.repository.CardRepository;
import com.payment.creditcardvalidator.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public ValidationResponse validateCard(ValidateCardRequest request) {

        var cardOptional = cardRepository.findByCardNumber(
                request.getCardNumber());

        TransactionStatus status = TransactionStatus.REJECTED;

        Card card = null;

        if (cardOptional.isPresent()) {

            card = cardOptional.get();

            if (card.getActive()
                    && card.getCvc().equals(request.getCvc())) {
                status = TransactionStatus.APPROVED;
            }
        }

        Transaction transaction = Transaction.builder()
                .card(card)
                .status(status)
                .transactionDate(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);

        return new ValidationResponse(
                status.name());
    }

    @Override
    public Card createCard(CreateCardRequest request) {

        Card card = Card.builder()
                .cardNumber(request.getCardNumber())
                .cvc(request.getCvc())
                .active(true)
                .createdAt(LocalDateTime.now())
                .build();

        return cardRepository.save(card);
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}
