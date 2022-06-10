package com.example.api_conimal.post.repository;

import com.example.api_conimal.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post.PostLists> findAllBy();
}
