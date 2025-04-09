package com.example.puzzleappbackend.puzzle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuzzleResponse {
    private List<Puzzle> puzzles;
}
