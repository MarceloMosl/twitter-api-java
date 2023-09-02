package com.twitter.ttapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.ttapi.dtos.UserDto;
import com.twitter.ttapi.models.UserModel;
import com.twitter.ttapi.repository.LoginRepo;

@Service
public class LoginService {

    @Autowired
    private LoginRepo loginRepo;

    public boolean loginUser(UserDto data) {

        UserModel usernameAvailable = loginRepo.findByUsername(data.username());

        if (usernameAvailable != null) {
            return false;
        }

        if (data.avatar() == null || data.username() == null) {
            return false;
        }

        loginRepo.save(new UserModel(data));

        return true;
    }

}
