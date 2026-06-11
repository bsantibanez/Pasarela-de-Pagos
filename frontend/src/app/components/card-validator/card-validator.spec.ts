import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardValidator } from './card-validator';

describe('CardValidator', () => {
  let component: CardValidator;
  let fixture: ComponentFixture<CardValidator>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardValidator],
    }).compileComponents();

    fixture = TestBed.createComponent(CardValidator);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
