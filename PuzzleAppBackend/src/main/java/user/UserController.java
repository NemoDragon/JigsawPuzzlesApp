package user;

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
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<UserResponse> getUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(new UserResponse(users));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addUser(@RequestBody UserRequest userRequest) {
        Integer userId = userService.addUser(userRequest.getUser());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(userId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updatedUser(@PathVariable Integer userId, @RequestBody UserRequest userRequest) {
        try {
            User updatedUser = userService.updateUser(userId, userRequest.getUser());
            return ResponseEntity.ok(updatedUser);
        } catch(EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
