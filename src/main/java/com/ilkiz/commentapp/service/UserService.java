package com.ilkiz.commentapp.service;

import com.ilkiz.commentapp.repository.IUserRepository;
import com.ilkiz.commentapp.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User> orderByName(){
        return userRepository.findAllByOrderByNameAsc();
    }

    public Optional<List<User>> containingName(String name){
        return userRepository.findAllOptionalByNameContainingIgnoreCase(name);
    }

    public Optional<List<User>> containingEmail(String email){
        return userRepository.findAllOptionalByEmailContainingIgnoreCase(email);
    }

    public Optional<List<User>> endingWithEmail(String email){
        return userRepository.findAllOptionalByEmailEndingWith(email);
    }

    public Optional<User> login (String email, String password){
        return userRepository.findOptionalByEmailAndPassword(email,password);
    }

    public Optional<List<User>> controlPassword(int password){
        return userRepository.controlPassword(password);
    }
}
