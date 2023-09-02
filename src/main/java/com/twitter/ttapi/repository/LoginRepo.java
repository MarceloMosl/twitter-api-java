package com.twitter.ttapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.ttapi.models.UserModel;

public interface LoginRepo extends JpaRepository<UserModel, Long> {

    UserModel findByUsername(String username);

}
