package com.example.controllers;

import com.example.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.dto.PostDTO;


@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDTO postDto) {
        postService.createPost(postDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public String  showAllPosts() {
        return postService.showAllPosts();
    }

    @GetMapping
    public String getSinglePost(@PathVariable @RequestBody Long id) {
        return postService.getOnePost();
    }
}
