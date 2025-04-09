package com.example.puzzleappbackend.completed;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/completed")
@RequiredArgsConstructor
@CrossOrigin
public class CompletedController {
    @Autowired
    private CompletedService completedService;

    @GetMapping()
    public ResponseEntity<CompletedResponse> getAllCompleted() {
        List<Completed> allCompleted = completedService.getAllCompleted();
        return ResponseEntity.ok(new CompletedResponse(allCompleted));
    }

    @GetMapping("/{completedId}")
    public ResponseEntity<Completed> getCompletedById(@PathVariable Integer completedId) {
        Optional<Completed> completed = completedService.getCompletedById(completedId);
        return completed.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addCompleted(@RequestBody CompletedRequest completedRequest) {
        Integer completedId = completedService.addCompleted(completedRequest.getCompleted());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{completedId}")
                .buildAndExpand(completedId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{completedId}")
    public ResponseEntity<Completed> updateCompleted(@PathVariable Integer completedId, @RequestBody CompletedRequest completedRequest) {
        try {
            Completed updatedCompleted = completedService.updateCompleted(completedId, completedRequest.getCompleted());
            return ResponseEntity.ok(updatedCompleted);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{completedId}")
    public ResponseEntity<Void> deleteCompleted(@PathVariable Integer completedId) {
        try {
            completedService.deleteCompleted(completedId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
