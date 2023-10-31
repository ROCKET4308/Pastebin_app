package com.rocket.postservice.repository;


import com.rocket.postservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findByPostName(String postName);
}
