package com.Insta.instaClone.service;

import com.Insta.instaClone.dto.UserDto;
import com.Insta.instaClone.exception.CommentException;
import com.Insta.instaClone.exception.PostException;
import com.Insta.instaClone.exception.UserException;
import com.Insta.instaClone.modal.Comment;
import com.Insta.instaClone.modal.Post;
import com.Insta.instaClone.modal.User;
import com.Insta.instaClone.repository.CommentRepository;
import com.Insta.instaClone.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class CommentServiceImplementations implements CommentService{

    @Autowired
      private CommentRepository commentRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostRepository postRepository;





    @Override
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws UserException, PostException {
        User user=userService.findUserById(userId);

//        Post post = postService.findPostById(postId);
        UserDto userDto=new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUserImage(user.getImage());
        userDto.setUsername(user.getUsername());

        comment.setUser(userDto);
        comment.setCreatedAt(LocalDateTime.now());

        Comment createdComment = commentRepository.save(comment);

//        post.getComments().add(createdComment);
//        PostRepository.save(post);

        return createdComment;
    }

    @Override
    public Comment findCommentById(Integer commentId) throws CommentException {

        Optional<Comment> opt=commentRepository.findById(commentId);
        if(opt.isPresent()){
            return opt.get();
        }
      throw  new CommentException("Comment is not exist with id:" +commentId);

    }

    @Override
    public Comment likecomment(Integer commentId, Integer userId) throws CommentException, UserException {

        User user=userService.findUserById(userId);
        Comment comment=findCommentById(userId);

        UserDto userDto=new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUserImage(user.getImage());
        userDto.setUsername(user.getUsername());

        comment.getLikedByUsers().add(userDto);
        return commentRepository.save(comment);


    }

    @Override
    public Comment unlikeComment(Integer commentId, Integer userId) throws CommentException, UserException {
        User user=userService.findUserById(userId);
        Comment comment=findCommentById(userId);

        UserDto userDto=new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUserImage(user.getImage());
        userDto.setUsername(user.getUsername());

        comment.getLikedByUsers().remove(userDto);
        return commentRepository.save(comment);
    }
}
