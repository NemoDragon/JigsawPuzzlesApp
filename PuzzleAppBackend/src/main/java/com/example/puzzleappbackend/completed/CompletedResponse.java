package com.example.puzzleappbackend.completed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompletedResponse {
    List<Completed> allCompleted;
}
