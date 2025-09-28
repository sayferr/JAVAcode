package com.studeis.mysql_intro.repositories.homeWork.userController;

import com.studeis.mysql_intro.repositories.entities.User;
import com.studeis.mysql_intro.repositories.homeWork.userService.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class Controller {

    public Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.save(user);
    }

    // READ ALL
    @GetMapping
    public Iterable<User> getAllUsers() {
        return service.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return service.findById(id);
    }

    // UPDATE (через save – если id есть, обновит)
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return service.save(user);
    }

    // DELETE BY ID
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        service.deleteById(id);
    }
}