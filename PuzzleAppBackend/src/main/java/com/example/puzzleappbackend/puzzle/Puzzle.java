package com.example.puzzleappbackend.puzzle;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "puzzles")
public class Puzzle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "puzzle_id")
    private Integer puzzleId;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "company")
    private String company;

    @Column(name = "pieces_number")
    private int piecesNumber;

    @Column(name = "image_url")
    private String imageUrl;
}
