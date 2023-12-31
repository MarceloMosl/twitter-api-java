package com.twitter.ttapi.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.ttapi.dtos.PostDto;
import com.twitter.ttapi.models.PostModel;
import com.twitter.ttapi.models.UserModel;
import com.twitter.ttapi.repository.LoginRepo;
import com.twitter.ttapi.repository.PostRepo;

@Service
public class PostService {

    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private PostRepo postRepo;

    public boolean createPost(PostDto data) {

        UserModel userOnline = loginRepo.findByUsername(data.username());

        if (userOnline == null) {
            return false;
        }

        PostModel newData = new PostModel();
        newData.setAvatar(userOnline.getAvatar());
        newData.setUsername(data.username());
        newData.setText(data.text());

        postRepo.save(newData);

        return true;

    }

    public List<PostModel> getPotsByPage(int page) {

        List<PostModel> allPosts = postRepo.findAll();

        return allPosts;

    }

    public List<PostModel> getPotsByUserName(String username) {

        UserModel userOnline = loginRepo.findByUsername(username);

        if (userOnline == null) {
            return Collections.emptyList();
        }

        return postRepo.findAllByUsername(username);
    }
}
