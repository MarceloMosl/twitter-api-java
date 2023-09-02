package com.twitter.ttapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.ttapi.models.PostModel;

public interface PostRepo extends JpaRepository<PostModel, Long> {
    List<PostModel> findAllByUsername(String username);
}
