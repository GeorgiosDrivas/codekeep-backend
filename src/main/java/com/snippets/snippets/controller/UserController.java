package com.snippets.snippets.controller;

import com.snippets.snippets.model.User;
import com.snippets.snippets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody User user){ // It returns String for some reason. Maybe should return nothing
        user = userService.createUser(user);
        return new ResponseEntity<>("User is created successfully with id: " + user.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(@PathVariable("id") Long id) throws Exception {
        boolean isUserExist = userService.isUserExist(id);
        if (isUserExist)
        {
            User user = userService.getUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else
        {
            throw new Exception("User not found");
        }

    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) throws Exception {
        boolean isUserExist = userService.isUserExist(id);
        if (isUserExist)
        {
            userService.deleteUser(id);
            return new ResponseEntity<>("User is deleted successfully", HttpStatus.OK);
        }
        else
        {
            throw new Exception("User not found");

        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> loginUser(@RequestBody User myUser) {
        User user = userService.getUserByUsernameAndPassword(myUser.getUsername(), myUser.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }

}