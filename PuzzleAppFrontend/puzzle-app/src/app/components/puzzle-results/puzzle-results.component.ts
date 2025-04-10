import { Component, OnInit } from '@angular/core';
import { Puzzle } from '../../models/puzzle.model';
import { PuzzleService } from '../../services/puzzle/puzzle.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-puzzle-results',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './puzzle-results.component.html',
  styleUrl: './puzzle-results.component.css',
})
export class PuzzleResultsComponent implements OnInit {
  puzzles: Puzzle[] = [];
  searchTerm: string = '';
  newPuzzle: Puzzle = {} as Puzzle;

  constructor(private puzzleService: PuzzleService) {}

  ngOnInit() {
    this.puzzleService.getPuzzles().subscribe((data) => {
      this.puzzles = data.puzzles;
    });
  }

  addPuzzle() {
    this.puzzleService.addPuzzle(this.newPuzzle).subscribe((puzzle) => {
      console.log('Puzzle added:', puzzle);
      this.puzzles.push(puzzle);
      this.newPuzzle = {} as Puzzle;
    });
  }

  deletePuzzle(puzzleId: number) {
    this.puzzleService.deletePuzzle(puzzleId).subscribe(() => {
      console.log('Puzzle deleted:', puzzleId);
      this.puzzles = this.puzzles.filter(
        (puzzle) => puzzle.puzzleId !== puzzleId
      );
    });
  }
}
