import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private backendUsersUrl = 'http://localhost:8080/users';

  constructor(private http: HttpClient) {}
}
