package com.Insta.instaClone.controller;


import com.Insta.instaClone.exception.UserException;
import com.Insta.instaClone.modal.User;
import com.Insta.instaClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;



    public ResponseEntity<User> registeUserHandler(@RequestBody User user) throws UserException{

        User createdUser =userService.registerUser(user);
        return  new ResponseEntity<User>(createdUser, HttpStatus.OK);
    }


}
