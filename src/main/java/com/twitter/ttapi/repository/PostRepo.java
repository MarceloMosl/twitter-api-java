package com.twitter.ttapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.ttapi.models.PostModel;

public interface PostRepo extends JpaRepository<PostModel, Long> {

}
