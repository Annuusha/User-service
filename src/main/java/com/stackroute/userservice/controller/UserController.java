package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserServiceIpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    public UserController(UserServiceIpl userService) {
        this.userService = userService;
    }

    private UserServiceIpl userService;

    //mapping json object to the User object
    @PostMapping("/user")
    public ResponseEntity<User> savedUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser(@RequestBody User user)
    {
      return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> Update(@RequestBody User user,@PathVariable int id) {
        return new ResponseEntity<User>(userService.Update(user,id),HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable int id)
    {
        return new ResponseEntity<Optional<User>>(userService.getById(id),HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userService.deleteUser(id);
    }





}
