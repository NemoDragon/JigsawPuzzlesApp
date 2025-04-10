import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Puzzle } from '../../models/puzzle.model';

@Injectable({
  providedIn: 'root',
})
export class PuzzleService {
  private backendPuzzlesUrl = 'http://localhost:8080/puzzles';

  constructor(private http: HttpClient) {}

  getPuzzles(): Observable<{ puzzles: Puzzle[] }> {
    return this.http.get<{ puzzles: Puzzle[] }>(this.backendPuzzlesUrl);
  }

  addPuzzle(puzzle: Puzzle): Observable<Puzzle> {
    return this.http.post<Puzzle>(this.backendPuzzlesUrl, { puzzle });
  }

  deletePuzzle(puzzleId: number): Observable<void> {
    return this.http.delete<void>(`${this.backendPuzzlesUrl}/${puzzleId}`);
  }

  searchPuzzles(searchTerm: string): Observable<{ puzzles: Puzzle[] }> {
    return this.http.get<{ puzzles: Puzzle[] }>(
      `${this.backendPuzzlesUrl}?search=${searchTerm}`
    );
  }
}
