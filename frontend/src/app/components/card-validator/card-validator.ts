import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CardService } from '../../services/card.service';

@Component({
  selector: 'app-card-validator',
  imports: [FormsModule],
  templateUrl: './card-validator.html',
  styleUrl: './card-validator.css',
  standalone: true
})
export class CardValidator {

  cardNumber = '';
  cvc = '';
  result = '';

  constructor(
    private cardService: CardService
  ) {}

  isFormValid(): boolean {

    return (
      /^\d{12}$/.test(this.cardNumber) &&
      /^\d{3}$/.test(this.cvc)
    );

  }

  validateCard() {

    if (!this.isFormValid()) {
      return;
    }

    this.cardService.validateCard({
      cardNumber: this.cardNumber,
      cvc: this.cvc
    })
    .subscribe({
      next: (response) => {
        this.result = response.status;
      },
      error: () => {
        this.result = 'ERROR';
      }
    });

  }
}