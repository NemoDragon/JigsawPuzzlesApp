package puzzle;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/puzzles")
@RequiredArgsConstructor
@CrossOrigin
public class PuzzleController {
    @Autowired
    private PuzzleService puzzleService;

    @GetMapping()
    public ResponseEntity<PuzzleResponse> getPuzzles() {
        List<Puzzle> puzzles = puzzleService.getAllPuzzles();
        return ResponseEntity.ok(new PuzzleResponse(puzzles));
    }

    @GetMapping("/{puzzleId}")
    public ResponseEntity<Puzzle> getPuzzleById(@PathVariable Integer puzzleId) {
        Optional<Puzzle> puzzle = puzzleService.getPuzzleById(puzzleId);
        return puzzle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addPuzzle(@RequestBody PuzzleRequest puzzleRequest) {
        Integer puzzleId = puzzleService.addPuzzle(puzzleRequest.getPuzzle());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{puzzleId}")
                .buildAndExpand(puzzleId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{puzzleId}")
    public ResponseEntity<Puzzle> updatePuzzle(@PathVariable Integer puzzleId, @RequestBody PuzzleRequest puzzleRequest) {
        try {
            Puzzle updatedPuzzle = puzzleService.updatePuzzle(puzzleId, puzzleRequest.getPuzzle());
            return ResponseEntity.ok(updatedPuzzle);
        } catch(EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{puzzleId}")
    public ResponseEntity<Void> deletePuzzle(@PathVariable Integer puzzleId) {
        try {
            puzzleService.deletePuzzle(puzzleId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
