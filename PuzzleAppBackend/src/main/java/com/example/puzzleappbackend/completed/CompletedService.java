package com.example.puzzleappbackend.completed;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompletedService {
    private final CompletedRepository completedRepository;

    public List<Completed> getAllCompleted() {
        return completedRepository.findAll();
    }

    public Optional<Completed> getCompletedById(Integer completedId) {
        return completedRepository.findById(completedId);
    }

    public Integer addCompleted(Completed completed) {
        Completed savedCompleted = Completed.builder()
                .completedId(completed.getCompletedId())
                .user(completed.getUser())
                .puzzle(completed.getPuzzle())
                .date(completed.getDate())
                .time(completed.getTime())
                .firstTime(completed.getFirstTime())
                .build();
        return completedRepository.save(savedCompleted).getCompletedId();
    }

    public Completed updateCompleted(Integer completedId, Completed completed) {
        Completed foundCompleted = completedRepository.findById(completedId).orElseThrow(EntityNotFoundException::new);
        foundCompleted.setUser(completed.getUser());
        foundCompleted.setPuzzle(completed.getPuzzle());
        foundCompleted.setDate(completed.getDate());
        foundCompleted.setTime(completed.getTime());
        foundCompleted.setFirstTime(completed.getFirstTime());
        return completedRepository.save(foundCompleted);
    }

    public void deleteCompleted(Integer completedId) {
        if (!completedRepository.existsById(completedId)) {
            throw new EntityNotFoundException();
        }
        completedRepository.deleteById(completedId);
    }
}
