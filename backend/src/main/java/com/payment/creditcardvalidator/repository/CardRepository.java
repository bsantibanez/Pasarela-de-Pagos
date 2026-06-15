package com.payment.creditcardvalidator.repository;

import com.payment.creditcardvalidator.entities.Card;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByCardNumber(String cardNumber);

}