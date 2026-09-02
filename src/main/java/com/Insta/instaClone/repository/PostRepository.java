package com.Insta.instaClone.repository;

import com.Insta.instaClone.modal.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
