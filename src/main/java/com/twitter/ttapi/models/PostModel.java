package com.twitter.ttapi.models;

import com.twitter.ttapi.dtos.CreatePostDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity

@NoArgsConstructor
public class PostModel {

    public PostModel(CreatePostDto req) {
        this.username = req.username();
        this.avatar = req.avatar();
        this.text = req.text();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(length = 80, nullable = false)
    String username;

    @Column(nullable = false)
    String avatar;

    @Column(nullable = false)
    String text;

}