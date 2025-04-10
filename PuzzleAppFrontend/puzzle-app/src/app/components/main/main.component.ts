import { Component, OnInit } from '@angular/core';
import { Puzzle } from '../../models/puzzle.model';
import { PuzzleService } from '../../services/puzzle/puzzle.service';
import { Console } from 'console';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css',
})
export class MainComponent implements OnInit {
  puzzles: Puzzle[] = [];

  constructor(private puzzleService: PuzzleService) {}

  ngOnInit() {
    this.puzzleService.getPuzzles().subscribe((response) => {
      this.puzzles = response.puzzles;
      console.log(this.puzzles);
    });
  }
}
