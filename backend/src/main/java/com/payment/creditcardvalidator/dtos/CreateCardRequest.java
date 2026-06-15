package com.payment.creditcardvalidator.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateCardRequest {

    @NotBlank
    @Pattern(regexp = "\\d{12}")
    private String cardNumber;

    @NotBlank
    @Pattern(regexp = "\\d{3}")
    private String cvc;
}