package com.twitter.ttapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.ttapi.dtos.UserDto;
import com.twitter.ttapi.service.LoginService;

@RestController
@RequestMapping("/signup")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<Object> signUp(@RequestBody UserDto req) {
        String okMessage = "OK";
        String errorMessage = "Dados Invalidos";

        boolean response = loginService.loginUser(req);

        if (!response) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(Map.of("ErrorResponse", errorMessage));
        }

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Message", okMessage));
    }
}
