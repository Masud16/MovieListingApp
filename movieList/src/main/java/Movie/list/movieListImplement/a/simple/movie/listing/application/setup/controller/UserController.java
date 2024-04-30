package Movie.list.movieListImplement.a.simple.movie.listing.application.setup.controller;
import Movie.list.movieListImplement.a.simple.movie.listing.application.setup.entiry.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class UserController {

    private static final List<User> registeredUsers = new ArrayList<>();

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {

        if (user == null || user.getEmail() == null) {
            return ResponseEntity.badRequest().body("Invalid user, Please Insert an email!");
        }

        registeredUsers.add(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
