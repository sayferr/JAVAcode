//package com.studeis.junit.intro_junit.controllers;
//
//import com.studeis.junit.intro_junit.entities.Author;
//import com.studeis.junit.intro_junit.repositories.authorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/author")
//public class authorController {
//
//    @Autowired
//    private authorRepository authorRepository;
//
//
////CRUD
//
//    //Read all
//    @GetMapping
//    public ResponseEntity<List<Author>> getAll(){
//        List<Author> authors = authorRepository.findAll();
//        if(authors != null && authors.isEmpty()){
//            return ResponseEntity.ok(authors);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    //Read one
//    @GetMapping("/get={id}")
//    public ResponseEntity<Author> getOne(@PathVariable Long id){
////        Optional<Author> authors = authorRepository.findById(id);
////
////        if(authors.isPresent()){
////            return ResponseEntity.ok(authors.get());
////        }
////
////        return ResponseEntity.notFound().build();
//        return authorRepository
//                .findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    //Create
//    @PostMapping
//    public ResponseEntity<Author> create(@RequestBody Author author){
////        List<Author> authors = authorRepository.findAll();
////        if(authors.isEmpty()){
////            return ResponseEntity.badRequest().build();
////        }
////        return ResponseEntity.ok(authorRepository.save(author));
//        return ResponseEntity.ok(authorRepository.save(author));
//    }
//
//    //Update
//    @PutMapping("/{id}")
//    public ResponseEntity<Author> update(@RequestBody Long id,  @RequestBody Author author){
//        return authorRepository
//                .findById(id)
//                .map(exist ->{
//                    if(author.getEmail() != null){
//                        author.setEmail(author.getEmail());
//                    }
//
//                    if (author.getFirstName() != null){
//                        author.setFirstName(author.getFirstName());
//                    }
//
//                    if (author.getLastName() != null){
//                        author.setLastName(author.getLastName());
//                    }
//                    return ResponseEntity.ok(authorRepository.save(author));
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    //Delete
//    @DeleteMapping("/delete{id}")
//    public ResponseEntity<Void> deleteById(@PathVariable Long id){
//        return authorRepository
//                .findById(id)
//                .map(author -> {
//                    authorRepository.delete(author);
//                    return ResponseEntity.ok().<Void>build();
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//}
//
