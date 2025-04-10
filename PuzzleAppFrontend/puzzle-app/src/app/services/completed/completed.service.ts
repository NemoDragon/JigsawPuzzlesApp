import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CompletedService {
  private backendCompleteddUrl = 'http://localhost:8080/completed';

  constructor(private http: HttpClient) {}
}
