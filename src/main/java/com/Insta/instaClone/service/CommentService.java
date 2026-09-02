package com.Insta.instaClone.service;

import com.Insta.instaClone.exception.CommentException;
import com.Insta.instaClone.exception.PostException;
import com.Insta.instaClone.exception.UserException;
import com.Insta.instaClone.modal.Comment;

public interface CommentService {

    public Comment createComment(Comment comment, Integer postId, Integer userId) throws UserException, PostException ;

        public Comment findCommentById(Integer commentId) throws CommentException ;

        public Comment likecomment(Integer commentId, Integer userId) throws CommentException,UserException;

        public Comment unlikeComment(Integer commentId, Integer userId) throws CommentException, UserException;
    }

