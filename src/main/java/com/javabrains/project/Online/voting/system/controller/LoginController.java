package com.javabrains.project.Online.voting.system.controller;

import com.javabrains.project.Online.voting.system.model.LoginDetails;

import com.javabrains.project.Online.voting.system.security.JwtProvider;
import com.javabrains.project.Online.voting.system.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private VoterService voterService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/voter")
    public String loginVoter(@RequestBody LoginDetails loginDetails){
        voterService.loginVoter(loginDetails);
        String token = jwtProvider.generateToken(loginDetails.getEmail());
        return token;
    }
}
