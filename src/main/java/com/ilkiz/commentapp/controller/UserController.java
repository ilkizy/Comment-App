package com.ilkiz.commentapp.controller;

import com.ilkiz.commentapp.repository.entity.User;
import com.ilkiz.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/save")
    public ResponseEntity<User> save(String name, String surname, String email, String telephone, String password){

        User user = userService.save(User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .telephone(telephone)
                .password(password)
                .build());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/orderbyname")
    public ResponseEntity<List<User>> orderByName(){
        return ResponseEntity.ok(userService.orderByName());
    }

    @GetMapping("/containingname")
    public ResponseEntity<Optional<List<User>>> containingName(String name){
        return ResponseEntity.ok(userService.containingName(name));
    }

    @GetMapping("/containingemail")
    public ResponseEntity<Optional<List<User>>> containingEmail(String email){
        return ResponseEntity.ok(userService.containingEmail(email));
    }
    @GetMapping("/endwithemail")
    public ResponseEntity<Optional<List<User>>> endingWithEmail(String email){
        return ResponseEntity.ok(userService.endingWithEmail(email));
    }
    @GetMapping("/login")
    public ResponseEntity<Optional<User>> login (String email, String password){
        return ResponseEntity.ok(userService.login(email,password));
    }
    @GetMapping("/controlpassword")
    public ResponseEntity<Optional<List<User>>> controlPassword(int password){
        return ResponseEntity.ok(userService.controlPassword(password));
    }
}
