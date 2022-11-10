package com.example.springtemplate.service;

import com.example.springtemplate.model.Post;
import com.example.springtemplate.model.PostResponse;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Log4j2

@Service
public class PostService {
    private final RestTemplate restTemplate;

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${test.url}")
    private String url;

    public PostResponse createPost(Post post) {
        HttpEntity<Post> httpEntity = new HttpEntity<>(post);
        ResponseEntity<PostResponse> postResponse = restTemplate.exchange(url + "/posts", HttpMethod.POST, httpEntity, PostResponse.class);
        return postResponse.getBody();
    }

    public Post getPost(Long id) {
        Post post = new Post();
        post = restTemplate.getForObject(url + "/posts/{id}", Post.class, id);
        log.info("get with id " + id + " succesfully");
        return post;
    }

    public void deleteByUserId(Long id) {

        restTemplate.delete(url + "/posts/{id}", id);
        log.info("deleted with id" + id + " successfull");

    }

    public PostResponse updatePost(Long id, PostResponse postResponse) {
        HttpEntity httpEntity=new HttpEntity<>(postResponse);
        ResponseEntity<PostResponse> postResponse9= restTemplate.exchange(url+"/posts/"+id,HttpMethod.PUT,httpEntity,
                PostResponse.class);
        return postResponse9.getBody();
    }
}

