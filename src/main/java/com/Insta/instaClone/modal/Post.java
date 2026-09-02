//package com.Insta.instaClone.modal;
//
//import com.Insta.instaClone.dto.UserDto;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.Comments;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Getter
//@Setter
//@Data
//@AllArgsConstructor
//@Entity
//@Table(name = "post")
//public class Post {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//    private String caption;
//
//    private String image;
//    private String location;
//    private LocalDateTime createdAt;
//
//
//    @Embedded
//    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
//    @AttributeOverride(name = "email", column = @Column(name = "user_email"))
////    @AttributeOverride(name = "username", column = @Column(name = "user_name"))
//
//    private UserDto user;
//
//    @OneToMany
//  private List<Comments> comments = new ArrayList<>();
//
//
//
//    @Embedded
//    @ElementCollection
//    @JoinTable(name = "LikedByUsers" , joinColumns = @JoinColumn(name = "user_id"))
//    private Set<UserDto> LikedByUsers = new HashSet<UserDto>();
//
//
//
//}



package com.Insta.instaClone.modal;

import com.Insta.instaClone.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Data
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String caption;
    private String image;
    private String location;
    private LocalDateTime createdAt;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    @AttributeOverride(name = "email", column = @Column(name = "user_email"))
    private UserDto user;

    // ✅ Fix: Import your own Comments class, not org.hibernate.annotations.Comments
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();  // Note: should be Comments (capital C)

    @Embedded
    @ElementCollection
    @JoinTable(name = "LikedByUsers", joinColumns = @JoinColumn(name = "user_id"))
    private Set<UserDto> LikedByUsers = new HashSet<UserDto>();

    // Add a no-args constructor
    public Post() {
    }
}