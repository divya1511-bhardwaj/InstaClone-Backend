package com.Insta.instaClone.service;

import com.Insta.instaClone.exception.UserException;
import com.Insta.instaClone.modal.User;
import com.Insta.instaClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImplementations implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) throws UserException {
        return null;
    }

    @Override
    public User findUserById(Integer userId) throws UserException {
        return null;
    }

    @Override
    public User findUserByProfile(String token) throws UserException {
        return null;
    }

    @Override
    public User findUserByUsername(String username) throws UserException {
        return null;
    }

    @Override
    public String followUser(Integer reqUserId, Integer followUserId) throws UserException {
        return "";
    }

    @Override
    public String unFollowUser(Integer reqUserId, Integer followUserId) throws UserException {
        return "";
    }

    @Override
    public List<User> findUserByIds(List<Integer> userIds) throws UserException {
        return List.of();
    }

    @Override
    public List<User> searchUser(String query) throws UserException {
        return List.of();
    }

    @Override
    public User updateUserDetails(User updatedUser, User existingUser) throws UserException {
        return null;
    }
}
