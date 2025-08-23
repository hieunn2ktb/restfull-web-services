package com.example.rest.webservices.restfull_web_services.controller;

import com.example.rest.webservices.restfull_web_services.entity.Post;
import com.example.rest.webservices.restfull_web_services.entity.User;
import com.example.rest.webservices.restfull_web_services.exception.UserNotFoundException;
import com.example.rest.webservices.restfull_web_services.repository.UserRepository;
import com.example.rest.webservices.restfull_web_services.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class UserJpaResource {
    private final UserDaoService userDaoService;
    private final UserRepository userRepository;

    public UserJpaResource(UserDaoService userDaoService, UserRepository userRepository) {
        this.userDaoService = userDaoService;
        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user == null) throw new UserNotFoundException("id:"+id);

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User saveUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> delete(@PathVariable int id) {
        userRepository.deleteById(id);
        return null;
    }
}
