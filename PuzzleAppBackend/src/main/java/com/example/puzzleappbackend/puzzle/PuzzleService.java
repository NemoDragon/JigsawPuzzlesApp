package com.example.puzzleappbackend.puzzle;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PuzzleService {
    private final PuzzleRepository puzzleRepository;

    public List<Puzzle> getAllPuzzles() { return puzzleRepository.findAll(); }

    public Optional<Puzzle> getPuzzleById(Integer puzzleId) {
        return puzzleRepository.findById(puzzleId);
    }

    public List<Puzzle> getPuzzlesBySearchTerm(String searchTerm) {
        List<Puzzle> puzzles = puzzleRepository.findAll();
        return puzzles.stream().filter(x -> x.getTitle().contains(searchTerm)).toList();
    }

    public Integer addPuzzle(Puzzle puzzle) {
        Puzzle savedPuzzle = Puzzle.builder()
                .puzzleId(puzzle.getPuzzleId())
                .title(puzzle.getTitle())
                .category(puzzle.getCategory())
                .company(puzzle.getCompany())
                .piecesNumber(puzzle.getPiecesNumber())
                .imageUrl(puzzle.getImageUrl())
                .build();
        return puzzleRepository.save(savedPuzzle).getPuzzleId();
    }

    public Puzzle updatePuzzle(Integer puzzleId, Puzzle puzzle) {
        Puzzle foundPuzzle = puzzleRepository.findById(puzzleId).orElseThrow(EntityNotFoundException::new);
        foundPuzzle.setTitle(puzzle.getTitle());
        foundPuzzle.setCategory(puzzle.getCategory());
        foundPuzzle.setCompany(puzzle.getCompany());
        foundPuzzle.setPiecesNumber(puzzle.getPiecesNumber());
        foundPuzzle.setImageUrl(puzzle.getImageUrl());
        return puzzleRepository.save(foundPuzzle);
    }

    public void deletePuzzle(Integer puzzleId) {
        if (!puzzleRepository.existsById(puzzleId)) {
            throw new EntityNotFoundException();
        }
        puzzleRepository.deleteById(puzzleId);
    }


}
