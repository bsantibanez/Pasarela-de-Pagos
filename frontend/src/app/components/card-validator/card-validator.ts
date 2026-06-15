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
  step = 1;

  constructor(private cardService: CardService) {}

  formatDisplay(num: string): string {
    return num.replace(/(.{4})/g, '$1 ').trim();
  }

  isCardNumberValid(): boolean {
    return /^\d{12}$/.test(this.cardNumber);
  }

  isFormValid(): boolean {
    return this.isCardNumberValid() && /^\d{3}$/.test(this.cvc);
  }

  goToStep2() {
    if (this.isCardNumberValid()) this.step = 2;
  }

  goToStep1() {
    this.step = 1;
    this.result = '';
  }

  validateCard() {
    if (!this.isFormValid()) return;

    this.cardService.validateCard({
      cardNumber: this.cardNumber,
      cvc: this.cvc
    }).subscribe({
      next: (response) => { this.result = response.status; },
      error: () => { this.result = 'ERROR'; }
    });
  }
}