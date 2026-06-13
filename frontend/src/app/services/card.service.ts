import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ValidateCardRequest } from '../models/validate-card-request';
import { ValidationResponse } from '../models/validation-response';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  private apiUrl = '/api/cards';

  constructor(private http: HttpClient) {}

  validateCard(
    request: ValidateCardRequest
  ): Observable<ValidationResponse> {

    return this.http.post<ValidationResponse>(
      `${this.apiUrl}/validate`,
      request
    );
  }
}