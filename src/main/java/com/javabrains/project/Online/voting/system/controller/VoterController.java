package com.javabrains.project.Online.voting.system.controller;

import com.javabrains.project.Online.voting.system.model.Voter;
import com.javabrains.project.Online.voting.system.security.JwtProvider;
import com.javabrains.project.Online.voting.system.service.MailService;
import com.javabrains.project.Online.voting.system.service.VoterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voter")
@Slf4j
public class VoterController {

    @Autowired
    private VoterService voterService;

    @Autowired
    private MailService mailService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<Voter> registerVoter(@RequestBody Voter voter){
        log.info("Going to register voter with details {}"+ voter);
        Voter savedVoter = voterService.registerVoter(voter);
        mailService.sendMail(voter);
        return new ResponseEntity<>(savedVoter, HttpStatus.CREATED);
    }

}
