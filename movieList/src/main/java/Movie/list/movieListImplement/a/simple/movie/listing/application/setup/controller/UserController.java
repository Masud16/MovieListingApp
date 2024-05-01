package Movie.list.movieListImplement.a.simple.movie.listing.application.setup.controller;
import Movie.list.movieListImplement.a.simple.movie.listing.application.setup.entiry.Movie;
import Movie.list.movieListImplement.a.simple.movie.listing.application.setup.entiry.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private static final List<User> registeredUsers = new ArrayList<>();

    // user registration with their email address
    private final Map<String, User> users = new HashMap<>();
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestParam String email) {
        String userId = "user-" + (users.size() + 1);
        User newUser = new User(userId, email);
        users.put(userId, newUser);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<Map<String, User>> getAllUser() {
        return ResponseEntity.ok(users);
    }

    //search by userId
    @GetMapping("/search/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = users.get(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    //Added movies to favorites.
    @PostMapping("/{userId}/favorites")
    public ResponseEntity<String> addFavoriteMovie(@PathVariable String userId,
                                                   @RequestBody Movie movie) {
        User user = users.get(userId);
        if (user != null) {
            user.addFavoriteMovie(movie);
            return ResponseEntity.ok("Movie added to favorites successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //Removing movies from their favorites
    @DeleteMapping("/{userId}/favorites/{movieName}")
    public ResponseEntity<String> removeFavoriteMovie(@PathVariable String userId,
                                                      @PathVariable String movieName) {
        User user = users.get(userId);
        if (user != null) {
            Movie movieToRemove = user.getFavoriteMovies()
                    .stream()
                    .filter(movie -> movie.getTitle().equals(movieName))
                    .findFirst()
                    .orElse(null);
            if (movieToRemove != null) {
                user.removeFavoriteMovie(movieToRemove);
                return ResponseEntity.ok("Movie removed from favorites successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


//    public ResponseEntity<String> registerUser(@RequestParam String email) {
//
//        if (user == null || user.getEmail() == null || user.getEmail().isEmpty()) {
//            return ResponseEntity.badRequest().body("Invalid user, Please Insert an email!");
//        }
//
//        for (User u : registeredUsers) {
//            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
//                return ResponseEntity.status(HttpStatus.CONFLICT).body("User already registered");
//            }
//        }
//
//        registeredUsers.add(user);
//        return ResponseEntity.ok("User registered successfully");
//    }
}
