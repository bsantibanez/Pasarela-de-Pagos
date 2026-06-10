package com.payment.creditcardvalidator.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number", nullable = false, unique = true, length = 12)
    private String cardNumber;

    @Column(nullable = false, length = 3)
    private String cvc;

    @Column(nullable = false)
    private Boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "card")
    private List<Transaction> transactions;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}