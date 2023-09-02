package com.twitter.ttapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.twitter.ttapi.dtos.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data

@Entity

@NoArgsConstructor
public class UserModel {

    public UserModel(UserDto req) {

        this.username = req.username();
        this.avatar = req.avatar();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(length = 80, nullable = false)
    String username;

    @Column(nullable = false)
    String avatar;

}
