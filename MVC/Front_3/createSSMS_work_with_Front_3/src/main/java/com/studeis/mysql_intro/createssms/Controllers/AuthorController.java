package com.studeis.mysql_intro.createssms.Controllers;

import com.studeis.mysql_intro.createssms.entityDB.Author;
import com.studeis.mysql_intro.createssms.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorRepo authorRepository;


    //CRUD

    //READ ALL
    @GetMapping
    public ResponseEntity<List<Author>> getAll() {
        List<Author> authors = authorRepository.findAll();
        if (authors != null && !authors.isEmpty()) {
            return ResponseEntity.ok(authors);
        }
        return ResponseEntity.noContent().build();
    }

    //READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable Long id) {
        return authorRepository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //CREATE
    @PostMapping()
    public ResponseEntity<Author> create(@RequestBody Author author) {
        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
        return ResponseEntity.ok(authorRepository.save(author));
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author author) {
        return authorRepository
                .findById(id)
                .map(exist -> {
                    if (author.getEmail() != null) {
                        exist.setEmail(author.getEmail());
                    }

                    if (author.getName() != null) {
                        exist.setName(author.getName());
                    }

                    if (author.getSurname() != null) {
                        author.setSurname(author.getSurname());
                    }

                    return ResponseEntity.ok(authorRepository.save(exist));
                })
                .orElse(ResponseEntity.notFound().build());
    }


    //DELETE ONE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return authorRepository
                .findById(id)
                .map(author -> {
                    authorRepository.delete(author);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
