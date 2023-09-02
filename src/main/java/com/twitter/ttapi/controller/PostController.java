package com.twitter.ttapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.ttapi.dtos.PostDto;
import com.twitter.ttapi.service.PostService;

@RestController
@RequestMapping("/tweets")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<Object> createPost(@RequestBody PostDto post) {
        String okMessage = "OK";
        String errorMessage = "Dados Invalidos";

        boolean response = postService.createPost(post);

        if (!response) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(Map.of("ErrorResponse", errorMessage));

        }

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Message", okMessage));
    }

}
