package com.rocket.postservice.service;

import com.rocket.postservice.entity.Post;
import com.rocket.postservice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public String createPostWithoutDeleteTime(String postName, String postText) {
        Post post = new Post(postName, postText, LocalDateTime.now());
        postRepository.save(post);
        return "Created successfully";
    }

    public Post getPostByName(String postName) {
        return postRepository.findByPostName(postName);
    }
}
