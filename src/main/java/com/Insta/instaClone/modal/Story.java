package com.Insta.instaClone.modal;

import com.Insta.instaClone.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Stories")
public class Story {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    @AttributeOverride(name = "email", column = @Column(name = "user_email"))
    private UserDto user;

    @NonNull
    private String iamge;
    private String caption;
    private LocalDateTime timestamp;

    //empty constructor
    public Story() {

    }


    public Story(Integer id, UserDto user, String iamge, String caption, LocalDateTime timestamp) {
        this.id = id;
        this.user = user;
        this.iamge = iamge;
        this.caption = caption;
        this.timestamp = timestamp;
    }

    //    getter setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getIamge() {
        return iamge;
    }

    public void setIamge(String iamge) {
        this.iamge = iamge;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}