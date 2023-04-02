package com.example.services;

import com.example.dto.PostDTO;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    public String createPost(PostDTO postDto) {
        return "Create Post successfull";
    }
    public String showAllPosts() {
        return "return post list";
    }

    public String getOnePost() {
        return "Return One post";
    }
}
