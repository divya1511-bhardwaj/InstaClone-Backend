package com.Insta.instaClone.modal;

import com.Insta.instaClone.dto.UserDto;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class comments {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    @AttributeOverride(name = "email", column = @Column(name = "user_email"))
    private UserDto users;


    private String Content;


    @Embedded
    @ElementCollection
    private Set<UserDto> LikedByUsers = new HashSet<UserDto>();

    private LocalDateTime CreateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUsers() {
        return users;
    }

    public void setUsers(UserDto users) {
        this.users = users;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Set<UserDto> getLikedByUsers() {
        return LikedByUsers;
    }

    public void setLikedByUsers(Set<UserDto> likedByUsers) {
        LikedByUsers = likedByUsers;
    }

    public LocalDateTime getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        CreateAt = createAt;
    }

    public comments(Integer id, UserDto users, String content, Set<UserDto> likedByUsers, LocalDateTime createAt) {
        this.id = id;
        this.users = users;
        Content = content;
        LikedByUsers = likedByUsers;
        CreateAt = createAt;
    }
}
