package com.studeis.mysql_intro.repositories.homeWork.userService;

import com.studeis.mysql_intro.repositories.DTOs.userDTO;
import com.studeis.mysql_intro.repositories.entities.User;
import com.studeis.mysql_intro.repositories.userRepository;

import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private userRepository userRepository;

    public Service(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
     return userRepository.save(user);
    }

    public Iterable<User> saveAll(Iterable<User> users){
        return userRepository.saveAll(users);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public boolean existsById(Long id){
        return userRepository.existsById(id);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public Iterable<User> findAllById(Iterable<Long> ids){
        return userRepository.findAllById(ids);
    }

    public long count(){
        return userRepository.count();
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }
}
