//package com.Insta.instaClone.modal;
//
//import com.Insta.instaClone.dto.UserDto;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import jakarta.persistence.Id;  // ✅ Correct
//
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@Data
//public class comments {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//
//    @Embedded
//    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
//    @AttributeOverride(name = "email", column = @Column(name = "user_email"))
//    private UserDto users;
//
//
//    private String Content;
//
//
//    @Embedded
//    @ElementCollection
//    private Set<UserDto> LikedByUsers = new HashSet<UserDto>();
//
//    private LocalDateTime CreateAt;
//
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
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor  // ✅ Add this
@Data
public class Comments {  // ✅ Capital C

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    @AttributeOverride(name = "email", column = @Column(name = "user_email"))
    private UserDto user;  // ✅ Changed from 'users' to 'user'

    private String content;  // ✅ lowercase

    @Embedded
    @ElementCollection
    private Set<UserDto> likedByUsers = new HashSet<>();  // ✅ camelCase

    private LocalDateTime createdAt;  // ✅ camelCase
}