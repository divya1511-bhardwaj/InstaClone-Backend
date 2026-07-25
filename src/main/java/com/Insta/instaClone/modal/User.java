package com.Insta.instaClone.modal;


import com.Insta.instaClone.dto.UserDto;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String name;
    private String email;
    private String mobile;
    private String bio;
    private String gender;
    private String image;
    private String password;



    @Embedded
    @ElementCollection
    private Set<UserDto> follower = new HashSet<UserDto>();

    @Embedded
    @ElementCollection
    private Set<UserDto> following = new HashSet<UserDto>();


    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Story> stories = new ArrayList<>();

    @ManyToMany
    private List<Post> savedPost = new ArrayList<>();






}
