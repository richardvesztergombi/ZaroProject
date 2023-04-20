package com.example.controllers;

import com.example.dto.PostDTO;
import com.example.dto.PostResponseDTO;
import com.example.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PostResponseDTO createPost(@RequestBody PostDTO postDto) {
        return postService.createPost(postDto);
    }

    @GetMapping("/all")
    public String showAllPosts() {
        return postService.showAllPosts();
    }

    @GetMapping
    public String getSinglePost(@PathVariable @RequestBody Long id) {
        return postService.getOnePost();
    }
}
