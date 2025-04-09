import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Puzzle } from '../models/puzzle.model';

@Injectable({
  providedIn: 'root',
})
export class PuzzleService {
  private backendPuzzlesUrl = 'http://localhost:8080/puzzles';

  constructor(private http: HttpClient) {}

  getPuzzles(): Observable<{ puzzles: Puzzle[] }> {
    return this.http.get<{ puzzles: Puzzle[] }>(this.backendPuzzlesUrl);
  }
}
