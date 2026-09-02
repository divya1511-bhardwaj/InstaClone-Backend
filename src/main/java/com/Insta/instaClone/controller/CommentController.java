package com.Insta.instaClone.controller;

import com.Insta.instaClone.exception.PostException;
import com.Insta.instaClone.exception.UserException;
import com.Insta.instaClone.modal.Comment;
import com.Insta.instaClone.modal.User;
import com.Insta.instaClone.service.CommentService;
import com.Insta.instaClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletionException;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping("/create/{postId}")
    public ResponseEntity<Comment> createCommentHandler(@RequestBody Comment comment,@PathVariable Integer postId, @RequestHeader("Authorization") String token) throws UserException, PostException {

        User user = userService.findUserByProfile(token);

        Comment createdComment = commentService.createComment(comment, postId, user.getId());

        return new ResponseEntity<Comment>(createdComment, HttpStatus.OK);
    }

//    @PutMapping("/like/{commentId}")
//    public ResponseEntity<Comment> likeCommentHandler(@RequestHeader("Authorization") String token) throws UserException, CompletionException {
//        User user=userService.findUserByProfile(token);
//        Comment comment=commentService.likecomment(commentId, user.getId());
//
//        return new ResponseEntity<Comment>(comment,HttpStatus.OK);
//    }
}
