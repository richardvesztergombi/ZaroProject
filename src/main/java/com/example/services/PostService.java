package com.example.services;

import com.example.dto.PostDTO;
import com.example.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public String createPost(PostDTO postDto) {
        return "Successed created post.";
    }

    public String showAllPosts() {
        return "Successed showed all post";
    }

    public String getOnePost() {
        return "Successed get one post";
    }
}
