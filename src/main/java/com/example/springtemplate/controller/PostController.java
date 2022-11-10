package com.example.springtemplate.controller;

import com.example.springtemplate.model.Post;
import com.example.springtemplate.model.PostResponse;
import com.example.springtemplate.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponse> createpost(@RequestBody Post post) {
        PostResponse postResponse = postService.createPost(post);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        Post post = postService.getPost(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping(value = "/posts/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponse> updatePost(@PathVariable Long id, @RequestBody PostResponse post) {
        PostResponse postResponse = postService.updatePost(id, post);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);

    }

    @DeleteMapping(value = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponse> deleteByuserId(@PathVariable Long id) {
        postService.deleteByUserId(id);
        return ResponseEntity.ok().build();
    }


}
