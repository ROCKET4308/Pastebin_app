package com.rocket.postservice.controller;

import com.rocket.postservice.entity.Post;
import com.rocket.postservice.entity.PostRequest;
import com.rocket.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createPost(@RequestBody PostRequest post){
        return postService.createPost(post.getPostName(), post.getPostText());
    }

    @PostMapping("/create/{deletionTime}")
    @ResponseStatus(HttpStatus.CREATED)
    public String createPostWithDeletionTime(@PathVariable LocalDateTime deletionTime, @RequestBody PostRequest post){
        return postService.createPostWithDeletionTime(post.getPostName(), post.getPostText(), deletionTime);
    }

    @GetMapping("/{postName}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPostByName(@PathVariable String postName){
        return postService.getPostByName(postName);
    }

    @DeleteMapping("/postCleanup")
    @ResponseStatus(HttpStatus.OK)
    public Integer postCleanup(){
        return postService.postCleanup();
    }


}
