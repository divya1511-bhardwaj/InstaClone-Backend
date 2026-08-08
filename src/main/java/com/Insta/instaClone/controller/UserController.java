package com.Insta.instaClone.controller;


import com.Insta.instaClone.exception.UserException;
import com.Insta.instaClone.modal.User;
import com.Insta.instaClone.response.MessageResponse;
import com.Insta.instaClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

   @GetMapping("id/{id}")
    public ResponseEntity<User> findUserByIdHandler(@PathVariable Integer id) throws UserException {
      User user=userService.findUserById(id);

      return new ResponseEntity<User>(user, HttpStatus.OK);

    }
    @GetMapping("username/{username}")
    public ResponseEntity<User> findUserByUsernameHandler(@PathVariable String username) throws UserException {
       User user=userService.findUserByUsername(username);

       return new ResponseEntity<User>(user, HttpStatus.OK);

    }

//    @PutMapping("follow/{followUserId}")
//    public MessageResponse followUserHandler(@PathVariable Integer followUserId) {
//        return null;
//    }

    @PutMapping("/req")
    public  MessageResponse findUserProfileHandler(@RequestHeader("Authorization") String token){
       return null;
    }


//    @GetMapping("m/{userIds}")
//    public User findByUserIdsHandler(@PathVariable List<Integer>){
//       List<Users> users=userService.findUserByIds(userIds);
//       return
//    }



}
