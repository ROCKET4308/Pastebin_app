package com.rocket.postservice.controller;

import com.rocket.postservice.entity.Post;
import com.rocket.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createPostWithoutDeleteTime(@RequestParam String postName, @RequestBody String postText){
        return postService.createPostWithoutDeleteTime(postName, postText);
    }

    @GetMapping("/{postName}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPostByName(@PathVariable String postName){
        return postService.getPostByName(postName);
    }


}
