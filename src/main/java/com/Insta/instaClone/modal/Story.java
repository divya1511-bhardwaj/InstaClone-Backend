package com.Insta.instaClone.modal;

import com.Insta.instaClone.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Data
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



}