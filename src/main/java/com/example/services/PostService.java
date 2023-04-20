package com.example.services;

import com.example.dto.PostDTO;
import com.example.dto.PostResponseDTO;
import com.example.entities.Post;
import com.example.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDTO createPost(PostDTO newPost) {
        Post post = new Post();
        PostResponseDTO returnValue = new PostResponseDTO();

        post.setPictureUrl(newPost.getPicture_url());
        post.setTitle(newPost.getTitle());
        post.setDescription(newPost.getDescription());

        Post storedPost = postRepository.save(post);

        returnValue.setId(storedPost.getId());
        returnValue.setPicture_url(storedPost.getPictureUrl());
        returnValue.setTitle(storedPost.getTitle());
        returnValue.setDescription(storedPost.getDescription());

        return returnValue;
    }

    public String showAllPosts() {
        return "Successed showed all post";
    }

    public String getOnePost() {
        return "Successed get one post";
    }
}
